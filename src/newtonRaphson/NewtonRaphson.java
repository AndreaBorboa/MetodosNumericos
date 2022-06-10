package newtonRaphson;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class NewtonRaphson {

    /**
     * Programa que calcula la raiz de f(x)= x^3 - 6x^2 + 11x - 6 por el método de Newton Raphson
     */ 
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        //Se solicitan los datos del valor de x0 y el error. 
        System.out.print("Valor de X0: ");
        double x = scanner.nextDouble();
        System.out.print("Error: ");
        double error = scanner.nextDouble();
        
        //Se manda a llamar al método newtonRaphson y se le envian como parametros x0 y el error.
        newtonRaphson(x, error);  
    }
    
    
    //Método que calcula la raiz de la funcion por el método de newton raphson.
    private static void newtonRaphson(double x, double error) {
        DecimalFormat formato = new DecimalFormat("0.######");//formato para los decimales de resultados.
        
        int iteracion = 0; // se inicializa la variable para mostrar las iteraciones
        double fx=f(x); // se calcula f(x)
        double deriv = derivada(x);
        
        //Encabezado de la tabla para los resultados 
        System.out.println("─♡───────────────────────────♡─");
        System.out.printf("%14s %10s %10s %10s","Iteracion","x","f(x)", "f'(x)");
        System.out.println();
        System.out.println("─♡───────────────────────────♡─");
        
        
        //Mientras que el valor absoluto de f(x) sea mayor al error se repite todo lo que esta dentro.
        while(Math.abs(fx)>error){
           
            deriv=derivada(x);
            //se imprimen los resultados de cada vuelta.
            System.out.format("%14s %10s %10s %10s",
                    iteracion,formato.format(x),formato.format(fx),formato.format(deriv));
            System.out.println();
            
            x=x-(f(x)/deriv); // se cambia el valor de x con la formula x = x - (f(x)/f'(x))
            fx=f(x);// se calcula f(x)
            deriv = derivada(x); //se calcula la derivada de x
            
            iteracion=iteracion+1; // contador para las iteraciones. 
        }
        System.out.println("─♡───────────────────────────♡─");
    }
    
    
    //Metodo que calcula la derivada
    private static double derivada(double x) {
        return 3 * Math.pow(x, 2) - (12 * x) + 11;
    }
    
    //Metodo para calcular la funcion.
     private static double f(double x) {
        return Math.pow(x, 3) - (6 * Math.pow(x, 2)) + (11 * x) - 6;
    }
    
}
