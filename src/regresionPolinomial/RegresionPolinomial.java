
package regresionPolinomial;

import java.util.Scanner;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author andre
 */
public class RegresionPolinomial {
    double sistemaEcuaciones[][]; //matriz para almacenar el sistema de ecuaciones
    double puntosx[];
    double puntosy[];
    double sumax = 0, sumax2 = 0, sumax3 = 0, sumax4 = 0, sumay = 0, sumaxy = 0, sumax2y = 0;
    int numeroElementos;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegresionPolinomial regresion = new RegresionPolinomial();
        regresion.leePuntos();
        regresion.regresionPolinomial();
        regresion.gaussJordan();
        regresion.despliegaSolucion();
        
        
    }
    
    
    public void leePuntos() {

        Scanner tec = new Scanner(System.in);
        
        System.out.println("Número de elementos: ");
        numeroElementos = tec.nextInt();
        puntosx = new double [numeroElementos];
        puntosy = new double [numeroElementos];
        
        System.out.println("Ingrese las coordenadas de los elementos: ");
        for (int f = 0; f < numeroElementos; f++) { 
            System.out.println(" — — — — —| Coordenadas [" + (f + 1) + "] |— — — — — ");

                    System.out.println("x:");
                    puntosx[f] = tec.nextDouble();  
                    
                    System.out.println("y:");
                    puntosy[f] = tec.nextDouble();
                
            }
        }
        
    
    public void creaSumatorias() {
        
        
        for (int i = 0; i < puntosx.length; i++) {
            sumax += puntosx[i];
            sumax2 += Math.pow(puntosx[i], 2);
            sumax3 += Math.pow(puntosx[i], 3);
            sumax4 += Math.pow(puntosx[i], 4);
            sumay += puntosy[i];
            sumaxy += (puntosx[i] * puntosy[i]);
            sumax2y += (Math.pow(puntosx[i], 2) * puntosy[i]);
        }
   
    }
    
    public void creaMatrizSumatorias(){
        sistemaEcuaciones = new double [3][4];
        
        sistemaEcuaciones[0][0] = puntosx.length;
        sistemaEcuaciones[0][1] = sumax;
        sistemaEcuaciones[0][2] = sumax2;
        sistemaEcuaciones[0][3] = sumay;
        
        sistemaEcuaciones[1][0] = sumax;
        sistemaEcuaciones[1][1] = sumax2;
        sistemaEcuaciones[1][2] = sumax3;
        sistemaEcuaciones[1][3] = sumaxy;
        
        sistemaEcuaciones[2][0] = sumax2;
        sistemaEcuaciones[2][1] = sumax3;
        sistemaEcuaciones[2][2] = sumax4;
        sistemaEcuaciones[2][3] = sumax2y;
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| MATRIZ DE SUMATORIAS |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        for(int f=0; f<3; f++){
            for(int c=0; c<4; c++){
                System.out.print(" " + this.sistemaEcuaciones[f][c] + " |");
                
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void regresionPolinomial(){
        creaSumatorias();
        creaMatrizSumatorias();
    }
    
    public void gaussJordan() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| METODO GAUSS JORDAN |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        
        int haceruno = 0; // variable que almacena el numero que se convertira a 1.
        
        for (int a = 0; a < 3; a++) { // mientras que a sea menor al numero de renglones se repite el ciclo. 
            double divisor = 0; // variable temporal 
            divisor = this.sistemaEcuaciones[haceruno][haceruno]; // el numero divisor va a ser igual al numero que se quiere convertir a 1.
            
            for (int y = 0; y < 4; y++) { // mientras que y sea menor al numero de columnas de el sistema de ecuaciones se repite el ciclo. 
                // se reemplaza el renglon donde se encuentra el numero a convertir en 1 por el renglon dividido en el numero que se quiere convertir a 1. 
                this.sistemaEcuaciones[haceruno][y] = this.sistemaEcuaciones[haceruno][y] / divisor; 
            }


            System.out.println("⚘ — — — — —| Convierte a uno |— — — — — ⚘");
            despliegaMatriz(); // se llama al metodo despliega solución para mostrar la matriz con el numero convertido a 1. 

            System.out.println("");

            System.out.println("⚘ — — — — —| Convierte a ceros |— — — — — ⚘");
            
            //ciclo para convertir el numero de arriba y abajo del 1 a ceros. 
            for (int x = 0; x < 3; x++) {
                if (x != haceruno) {
                    double c = this.sistemaEcuaciones[x][haceruno];
                    for (int z = 0; z < (4); z++) {
                        this.sistemaEcuaciones[x][z] = ((-1 * c) * this.sistemaEcuaciones[haceruno][z]) + this.sistemaEcuaciones[x][z];
                    }
                }
            }

            despliegaMatriz(); // se llama al metodo despliegaSolución() para mostrar la matriz con los numeros convertidos a 0. 
            System.out.println("");
            haceruno++;
        }

        
        //Se imprimen los valores de las x. 
        for (int x = 0; x < 3; x++) {
            System.out.println("a" + (x) + " : " + this.sistemaEcuaciones[x][3]);
        }
        System.out.println("");
    }
    
    
    //Metodo despliega soluación, muestra los valores actuales de la matriz. 
    public void despliegaMatriz() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < (4); y++) {
                System.out.print(" " + this.sistemaEcuaciones[x][y] + " |");
            }
            System.out.println("");
        }

    }
    
    public void despliegaSolucion(){
        System.out.println("Ecuación: ");
        System.out.println("y = " + sistemaEcuaciones[0][3] + " + " + sistemaEcuaciones[1][3] + "x + " + sistemaEcuaciones[2][3] + "x^2");
    }
    
    
}
