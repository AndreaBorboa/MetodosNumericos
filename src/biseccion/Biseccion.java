
package biseccion;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class Biseccion {

    
    /**
     * Programa que calcula la raiz de la funcion: f(x) = -2.1 + 6.21x - 3.9x^2 + 0.667x^3 con el método de bisección
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //Se solicitan los datos del valor de x izquierda, x derecha y el error. 
    System.out.print("Valor de x izquierda: ");
    double xizq = scanner.nextDouble();
    System.out.print("Valor de x derecha: ");
    double xder = scanner.nextDouble();
    System.out.print("Error: ");
    double error = scanner.nextDouble();
    
    //Se llama al metodo de biseccion y se le envian como parametros los datos ingresados por teclado. 
    biseccion(xizq, xder, error);
      
          
  }
    
    //Metodo que calcula xm, f(xm), f(xizq), f(xder) y reemplaza x derecha y x izquierda segun sea el caso. 
    private static void biseccion(double xizq, double xder, double error) {
        DecimalFormat formato = new DecimalFormat("0.####");//formato para los decimales de resultados. 
        
        double xm = 0;
        double fxm=0;
        
        xm=(xizq+xder)/2; // calcula xm
        fxm=f(xm); //obtiene f(xm) llamando al metodo "f" y enviando como parametro xm
        
        
        //Encabezado de la tabla para los resultados 
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %10s", "xi", "xd", "f(xi)", "f(xd)","xm","f(xm)");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        
        //Ciclo que se repite mientras el valor absoluto de f(xm) sea mayor al error. 
        while(Math.abs(fxm)>error){
            
            double fxizq = f(xizq); // se calcula f(xizq) llamando al metodo "f"
            double fxder = f(xder);// se calcula f(xder) llamando al metodo "f"
            xm=(xizq+xder)/2; // calcula xm
            fxm=f(xm);// calcula f(xm) llamando al metodo "f"
            
            //Se imprimen los resultados en la tabla con el formato indicado.
            System.out.format("%10s %10s %10s %10s %10s %10s",
                    formato.format(xizq),formato.format(xder),formato.format(fxizq),formato.format(fxder),formato.format(xm),formato.format(fxm));
            System.out.println();
           
            //condicion para reemplazar x izquiera o x derecha segun sea el caso. 
            if(fxm<0){
                if(fxizq<0){
                    xizq=xm;
                }else{
                    xder=xm;
                }
               
            }else{
                if(fxizq>0){
                    xizq=xm;
                }else{
                    xder=xm;
                }
                
            } 
        }
        
    }
    
    //Metodo que calcula la funcion solicitada 
    private static double f(double x) {
        return ( -2.1 + (6.21 * x) - (3.9 * Math.pow(x, 2)) + (0.667 * Math.pow(x, 3)) );
    }
    
}
