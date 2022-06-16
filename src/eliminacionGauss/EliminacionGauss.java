
package eliminacionGauss;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */

//Clase EliminacionGauss que contiene los metodos para calcular los valores de x 
public class EliminacionGauss {
    // Se declaran las variables globales dentro de la clase EliminacionGauss que se utilizaran en los metodos para calcular x del sistema de ecuaciones.
    private final DecimalFormat formato = new DecimalFormat("#0.000000"); // Formato para los decimales.
    private double[][] sistemaEcuaciones; // Matriz donde se almacenarán las ecuaciones iniciales del sistema de ecuaciones.
    private double[][] ecuacionesb; //Matriz donde se almacenaran las ecuaciones "b" del sistema de ecuaciones que son calculadas en el metodo eliminacionGauss()
    private double[] valoresX; // Arreglo donde se almacenaran las soluciones de x del sistema de ecuaciones es decir: x1,x2,x3, ++
    private int numeroEcuaciones; // Variable para almacenar la cantidad de ecuaciones pertenecientes al sistema de ecuaciones.
    
    public EliminacionGauss(){} //Contrucctor vacio de la clase EliminacionGauss
    
    
        
     /**
     * Programa que calcula el valor de x de un sistema de ecuaciones ingresado por teclado. 
     */
    public static void main(String[] args) {
        
       EliminacionGauss gauss = new EliminacionGauss(); // Se crea un objeto de tipo EliminacionGauss para poder utilizar los metodos.
       gauss.leeEcuaciones(); // Llama al metodo leeEcuaciones() que lee la cantidad de ecuaciones y los coeficiones de cada una.
       gauss.eliminacionGauss();// Llama al método eliminacionGauss() que calcula las x de la solucion de el sistema de ecuaciones ingresado por teclado.
       gauss.despligaSolucion();//Llama al metodo despliegaSolucion() que imprime las x de la solucion del sistema de ecuaciones ingresado por teclado. 
        
    }
    
    
    
    public int leeEcuaciones(){ //Metodo para leer las ecuaciones del sistema.
        
        Scanner scanner = new Scanner(System.in);
         
        this.sistemaEcuaciones = new double[3][4]; // se crea la matriz sistemaEcuaciones con elnumero de filas de numeroEuaciones y 4 columnas.
        
        
        System.out.println("Ingrese los valores de los coeficientes de las ecuaciónes: ");
        
        
        for(int f = 0; f < 3; f++){ //ciclo para leer el numero de la ecuacion que se solicita. 
            System.out.println("⚘ — — — — —| Ecuación [" +(f+1)+ "] |— — — — — ⚘");
            
            
            for(int c = 0; c < 3; c++){ // ciclo para leer los coeficientes.
                
                System.out.println("Coeficiente x"+(c+1)+":");
                this.sistemaEcuaciones[f][c] = scanner.nextDouble();
            }
            
            
            System.out.println("Resultado de ecuación "+(f+1)+":"); // lee los "=" de cada ecuación. 
            this.sistemaEcuaciones[f][3] = scanner.nextDouble();
        }
        
        
        return 3; // regresa el numero de ecuaciones necesarios para el metodo eliminacionGauss()
    }
   
    
    
    private void eliminacionGauss(){
        
        //Aqui se multiplican y restan las ecuaciones para sacar las ecuacionesb
        
        // se inicializa la matriz ecuacionesb en la matris sistemaEcuaciones para calcular las ecuacionesb
        this.ecuacionesb = this.sistemaEcuaciones.clone(); 
        
        //mientras que "n" sea menor al numero de ecuaciones se incrementa 1 en n.
        for(int n = 0; n < 3; n++){ 
            //mientras que f sea menor al tamaño de la matriz ecuacionesb se incrementa 1 en f.
            for(int f = n; f < this.ecuacionesb.length; f++){
                
                // si ecuacionesb en el renglon f y la columna n no es 0 o sistemaEcuaciones en el renglon f y columna 0 no es 1 entra.
                if(this.ecuacionesb[f][n] != 0 || this.sistemaEcuaciones[f][0] != 1){
                    //Se crea una variable "temporal" Numerodivisor que va a ser igual a la matriz ecuacionesb en el renglon f y columna n.
                    double Numerodivisor = this.ecuacionesb[f][n];
                    
                    //Mientras que c que es igual a n sea menor que el tamaño de la ecuacion del sistema de ecuaciones original en la posicion f se incrementa 1 en c.
                    for(int c = n; c < this.sistemaEcuaciones[f].length; c++){
                        //ecuacionesb en el renglon f y columna c  va a ser igual a ecuacionesb en el renglon f y columna c / el numero divisor que calculamos anteriormente.
                        this.ecuacionesb[f][c] = Double.parseDouble(this.formato.format((this.ecuacionesb[f][c]/Numerodivisor)));
                    }
                }
                
                //Si f no es igual a n 
                if(f != n){
                    //el numero que multiplica sera igual a ecuacionesb en el renglon f y columna n por -1
                    double NumeroQueMultiplica = this.ecuacionesb[f][n]*(-1);
                    //mientras que c que es igual a n sea menor a el tamaño de la ecuacion en la posicion f del sistema de ecuaciones original se incrementa 1 en c.
                    for(int c = n; c < this.sistemaEcuaciones[f].length; c++){
                        //ecuacionesb en el renglon f y columna c  va a ser igual a ecuacionesb en el renglon f y columna c + ecuacionesb en el renglon n y columna c por el numero que multiplica
                        this.ecuacionesb[f][c] = Double.parseDouble(this.formato.format(this.ecuacionesb[f][c]+(this.ecuacionesb[n][c]*NumeroQueMultiplica)));
                    }
                }
                
            
            }
        }
        
        //Aqui se sustituyen las x para sacar el valor de todas las x. 
        
        // El tamaño de valores de x va a ser igual al numero de ecuaciones. 
        this.valoresX = new double[3];
        
       //mientras que f que es igual al tamaño de la matriz ecuacionesb menos uno sea mayor a 0 se dismunuye 1 en f. 
        for(int f = this.ecuacionesb.length-1 ; f >= 0; f--){
            
            double suma = 0;
            int contador = 0;
            
            //mientras que c que es igual a f sea menor a el tamaño de ecuacionesb menos 1 incrementa 1 en c. 
            for(int c = f; c < this.ecuacionesb[f].length-1 ; c++){
                
                //Si el contador no es igual a 0 
                if(contador != 0){
                    //suma va a ser igual a ecuaciones b en el renglon f y columna c por el arreglo de valoresX en la pocision c. 
                    suma += (this.ecuacionesb[f][c] * this.valoresX[c]);    
                }
                contador++;
            }
            int columna = this.ecuacionesb[f].length-1; //variable para calcular la columna en ecuacionesb.
            //valoresX en la pocision f va a ser igual a ecuacionesb en el renglon f y la columna columna mas -1*suma entre ecuaciones b en el renglon y columna f.
            this.valoresX[f] = (this.ecuacionesb[f][columna]+(-1*suma))/this.ecuacionesb[f][f];
        }
    }
 
   
    

    
     public void despligaSolucion(){
        System.out.println("┌───────────Solución───────────┐");
        for(int f = 0; f< this.valoresX.length; f++){
            System.out.println("  x" + (f+1) + ": " + formato.format(this.valoresX[f]));
        }
         System.out.println("└────────────...────────────┘");
    }
    
    

}
    
    
    
