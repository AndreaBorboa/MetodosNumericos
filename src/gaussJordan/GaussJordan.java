package gaussJordan;

import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class GaussJordan {

    float sistemaEcuaciones[][]; // Se crea una matriz global que va a ser utilizada por todos los metodos de la clase GaussJordan para almacenar el sistema de ecuaciones e irlo modificando.

    
    //Metodo para leer las ecuaciones del sistema original
    public void leeEcuaciones() {

        Scanner tec = new Scanner(System.in);

        this.sistemaEcuaciones = new float[3][4]; // se le da un tamaño a la matriz de 3 renglones por 4 columnas.

        System.out.println("Ingrese los valores de los coeficientes de las ecuaciónes: ");

        for (int f = 0; f < 3; f++) { //ciclo para leer el numero de la ecuacion que se solicita. 
            System.out.println("⚘ — — — — —| Ecuación [" + (f + 1) + "] |— — — — — ⚘");


            for (int c = 0; c < 3; c++) { // ciclo para leer los coeficientes.

                System.out.println("Coeficiente x" + (c + 1) + ":");
                this.sistemaEcuaciones[f][c] = tec.nextFloat();
            }


            System.out.println("Resultado de ecuación " + (f + 1) + ":"); // lee los "=" de cada ecuación. 
            this.sistemaEcuaciones[f][3] = tec.nextFloat();
        }

    }

    public void gaussJordan() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| METODO GAUSS JORDAN |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        int haceruno = 0; // variable que almacena el numero que se convertira a 1.
        
        for (int a = 0; a < 3; a++) { // mientras que a sea menor al numero de renglones se repite el ciclo. 
            float divisor = 0; // variable temporal 
            divisor = this.sistemaEcuaciones[haceruno][haceruno]; // el numero divisor va a ser igual al numero que se quiere convertir a 1.
            
            for (int y = 0; y < 4; y++) { // mientras que y sea menor al numero de columnas de el sistema de ecuaciones se repite el ciclo. 
                // se reemplaza el renglon donde se encuentra el numero a convertir en 1 por el renglon dividido en el numero que se quiere convertir a 1. 
                this.sistemaEcuaciones[haceruno][y] = this.sistemaEcuaciones[haceruno][y] / divisor; 
            }


            System.out.println("⚘ — — — — —| Convierte a uno |— — — — — ⚘");
            despliegaSolucion(); // se llama al metodo despliega solución para mostrar la matriz con el numero convertido a 1. 

            System.out.println("");

            System.out.println("⚘ — — — — —| Convierte a ceros |— — — — — ⚘");
            
            //ciclo para convertir el numero de arriba y abajo del 1 a ceros. 
            for (int x = 0; x < 3; x++) {
                if (x != haceruno) {
                    float c = this.sistemaEcuaciones[x][haceruno];
                    for (int z = 0; z < (4); z++) {
                        this.sistemaEcuaciones[x][z] = ((-1 * c) * this.sistemaEcuaciones[haceruno][z]) + this.sistemaEcuaciones[x][z];
                    }
                }
            }

            despliegaSolucion(); // se llama al metodo despliegaSolución() para mostrar la matriz con los numeros convertidos a 0. 
            System.out.println("");
            haceruno++;
        }

        
        //Se imprimen los valores de las x. 
        for (int x = 0; x < 3; x++) {
            System.out.println("La variable X" + (x + 1) + " es: " + this.sistemaEcuaciones[x][3]);
        }
    }
    
    
    //Metodo despliega soluación, muestra los valores actuales de la matriz. 
    public void despliegaSolucion() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < (4); y++) {
                System.out.print(" " + this.sistemaEcuaciones[x][y] + " |");
            }
            System.out.println("");
        }

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GaussJordan jordan = new GaussJordan(); // se crea un objeto de la clase GaussJordan.
        jordan.leeEcuaciones(); // Se llama al metodo leeEcuaciones.
        jordan.gaussJordan(); //Se llama al metodo gaussJordan.
        
    }

}