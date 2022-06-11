
import java.text.DecimalFormat;
import java.util.Scanner;


/**
 *
 * @author Andrea Borboa Ramírez
 */
public class Secante {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        //Se solicitan los datos del valor de x izquierda, x derecha y el error. 
        System.out.print("Valor de x inicial: ");
        double xinicial = scanner.nextDouble();
        System.out.print("Valor de x actual: ");
        double xactual = scanner.nextDouble();
        System.out.print("Error: ");
        double error = scanner.nextDouble();
    
        //Se llama al metodo de secante y se le envian como parametros los datos ingresados por teclado. 
        secante(xinicial, xactual, error);
    }
    
    
    //Metodo que calcula la raiz de (1-(0.6*x))/x por debajo del error indicado por teclado con el metodo de la secante
    private static void secante(double xinicial, double xactual, double error) {
        DecimalFormat formato = new DecimalFormat("0.#####");//formato para los decimales de resultados. 
        double fxinicial=0.0;// se declara fxinicial
        double fxactual=0.0;// se declara fxactual
        double xnueva=0.0; // se declara xnueva
        
       
        fxinicial=f(xinicial); // se calcula f(xinicial) llamando al metodo f
        fxactual=f(xactual); // se calcula f(xactual) llamando al metodo f
      
        
        //Encabezado de la tabla para los resultados 
        System.out.println("─♡──────────────────────────────────♡─");
        System.out.printf("%10s %10s %10s %10s %10s", "xi-1", "xi", "xi+1", "f(xi-1)","f(xi)");
        System.out.println();
        System.out.println("─♡──────────────────────────────────♡─");
        
        //Mientras que el valor absoluto de fxactual sea mayor al error se repite.
        while(Math.abs(fxactual)>error){
            
             xnueva = xactual - ((fxactual*(xinicial-xactual)) / ((fxinicial)-(fxactual))); // se calcula el valor de la xnueva
            //Se imprimen los resultados en la tabla con el formato indicado.
            System.out.format("%10s %10s %10s %10s %10s",
                    formato.format(xinicial),formato.format(xactual),formato.format(xnueva),formato.format(fxinicial),formato.format(fxactual));
            System.out.println();
            
           
            xinicial=xactual; // se reemplaza el valor de la x inicial con el de la xactual
            xactual=xnueva; // se reemplaza el valor de xactual con el valor de xnueva anteriormente calculado.
            fxactual=f(xactual); // se calcula f(xactual) con la veriable xactual reemplazada por xnueva
            fxinicial=f(xinicial); // se calcula f(xinicial) con la variable xinicial reemplazada por xactual
            
        }
        
        System.out.println("─♡──────────────────────────────────♡─");
        
    }
    
    //Metodo que calcula la funcion solicitada 
    private static double f(double x) {
        return (1-(0.6*x))/x;
    }
    
}

