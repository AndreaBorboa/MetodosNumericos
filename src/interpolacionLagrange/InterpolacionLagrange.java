
package interpolacionLagrange;

import java.util.Scanner;

/**
 *
 * @author Andrea Borbao Ramírez
 */
public class InterpolacionLagrange {
    
    double puntosx[] = new double[4]; //Arreglo para almacenar las x de los puntos. 
    double puntosy[] = new double[4]; //Arreglo para almacenar las y de los puntos.
    double absisa=0; //Variable para almacenar la absisa.
    double ordenada=0;//Variable para almacenar la ordenada.
    double b0=0, b1=0,b2=0,b3=0; // variables para calcular las diviciones de cada punto.
    
    
    public static void main(String[] args) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| INTERPOLACIÓN DE LAGRANGE |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        InterpolacionLagrange lagrange = new InterpolacionLagrange();
        
        lagrange.leePuntos(); //Llama al metodo leePuntos.
        System.out.println("La la ordenada del punto interpolar es: " + lagrange.interpolacionLagrange()); //Imprime el return del metodo interpolacionLagrange.
        
    }
    
    public void leePuntos(){
        Scanner tec = new Scanner(System.in);
        
        
        System.out.println("Valor de la abscisa: ");
        absisa=tec.nextDouble(); //solicita el valor de la abscisa.
        
        System.out.println("Ingrese las coordenadas de los puntos"); 
        System.out.println("");
        
        for (int f = 0; f < 4; f++) {  //ciclopara solicitar los 4 puntos.
            System.out.println(" — — — — —| Punto [" + (f + 1) + "] |— — — — — ");
            
            System.out.println("x:");
            puntosx[f] = tec.nextDouble();
            
            System.out.println("y:");
            puntosy[f] = tec.nextDouble();
        }
        
        
    }
    
    public double interpolacionLagrange(){
        
        //Se calculan las diviciones correspondientes a cada punto para calcular la ordenada.
        b0=( ( (absisa-puntosx[1])*(absisa-puntosx[2])*(absisa-puntosx[3]) ) / ( (puntosx[0]-puntosx[1])*(puntosx[0]-puntosx[2])*(puntosx[0]-puntosx[3]) ) ) * puntosy[0];
        
        b1= ( ( (absisa-puntosx[0])*(absisa-puntosx[2])*(absisa-puntosx[3]) ) / ( (puntosx[1]-puntosx[0])*(puntosx[1]-puntosx[2])*(puntosx[1]-puntosx[3]) ) ) * puntosy[1];
        
        b2= ( ( (absisa-puntosx[0])*(absisa-puntosx[1])*(absisa-puntosx[3]) ) / ( (puntosx[2]-puntosx[0])*(puntosx[2]-puntosx[1])*(puntosx[2]-puntosx[3]) ) ) * puntosy[2];
        
        b3 = ( ( (absisa-puntosx[0])*(absisa-puntosx[1])*(absisa-puntosx[2]) ) / ( (puntosx[3]-puntosx[0])*(puntosx[3]-puntosx[1])*(puntosx[3]-puntosx[2]) ) ) * puntosy[3];
        
        ordenada = b0 + b1 + b2 + b3; //se suman todas las divisiones para calcular la ordenada.
        
       return ordenada; //regresa la ordenada.
    }
    
    
}
