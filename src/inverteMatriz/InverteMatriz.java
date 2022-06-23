
package inverteMatriz;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class InverteMatriz {
    
    float sistemaEcuaciones[][]; // Se crea una matriz global que va a ser utilizada por todos los metodos de la clase GaussJordan para almacenar el sistema de ecuaciones e irlo modificando.
    
    
     //Metodo para leer las ecuaciones del sistema original
    public void leeMatriz() {

        Scanner tec = new Scanner(System.in);

        this.sistemaEcuaciones = new float[3][6]; // se le da un tamaño a la matriz de 3 renglones por 4 columnas.

        System.out.println("Ingrese los valores de los coeficientes de las ecuaciónes: ");

        for (int f = 0; f < 3; f++) { //ciclo para leer el numero de la ecuacion que se solicita. 
            System.out.println("⚘ — — — — —| Ecuación [" + (f + 1) + "] |— — — — — ⚘");


            for (int c = 0; c < 3; c++) { // ciclo para leer los coeficientes.

                System.out.println("Coeficiente x" + (c + 1) + ":");
                this.sistemaEcuaciones[f][c] = tec.nextFloat();
            }
            
            ampliarMatriz(f);
        
        }

    }
    
    public void ampliarMatriz(int f){ //metodo para ampliar la matriz con 0 y 1 en donde es necesario. 
        
        switch(f){
                case 0:
                    this.sistemaEcuaciones[f][3] = 1 ;
                    this.sistemaEcuaciones[f][4] = 0 ;
                    this.sistemaEcuaciones[f][5] = 0 ; 
                    break;
                case 1:
                    this.sistemaEcuaciones[f][3] = 0 ;
                    this.sistemaEcuaciones[f][4] = 1 ;
                    this.sistemaEcuaciones[f][5] = 0 ; 
                    break;
                case 2:
                    this.sistemaEcuaciones[f][3] = 0 ;
                    this.sistemaEcuaciones[f][4] = 0 ;
                    this.sistemaEcuaciones[f][5] = 1 ; 
            }
    }
    
    public void invertirMatriz(){
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| MATRIZ INVERTIDA |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        despliegaMatriz();
        System.out.println("");
        
        int haceruno = 0; // variable que almacena el numero que se convertira a 1.
        
        for (int a = 0; a < 3; a++) { // mientras que a sea menor al numero de renglones se repite el ciclo. 
            float divisor = 0; // variable temporal 
            divisor = this.sistemaEcuaciones[haceruno][haceruno]; // el numero divisor va a ser igual al numero que se quiere convertir a 1.
            
            for (int y = 0; y < 6; y++) { // mientras que y sea menor al numero de columnas de el sistema de ecuaciones se repite el ciclo. 
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
                    float c = this.sistemaEcuaciones[x][haceruno];
                    for (int z = 0; z < 6; z++) {
                        this.sistemaEcuaciones[x][z] = ((-1 * c) * this.sistemaEcuaciones[haceruno][z]) + this.sistemaEcuaciones[x][z];
                    }
                }
            }

            despliegaMatriz(); // se llama al metodo despliegaSolución() para mostrar la matriz con los numeros convertidos a 0. 
            System.out.println("");
            haceruno++;
        }

        

    }
    
    //Metodo despliega soluación, muestra los valores actuales de la matriz. 
    public void despliegaMatriz() {
        DecimalFormat formato = new DecimalFormat("0.######");
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 6; y++) {
                System.out.print(" " + formato.format(this.sistemaEcuaciones[x][y]) + " |");
            }
            System.out.println("");
        }

    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       InverteMatriz inverteMatriz = new InverteMatriz(); // se crea un objeto de la clase InvierteMatriz.
        inverteMatriz.leeMatriz();// Se llama al metodo leeEcuaciones.
        inverteMatriz.invertirMatriz(); //Se llama al metodo invertrMatriz.
    }
    
}
