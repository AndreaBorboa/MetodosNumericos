/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regresionLinearMultiple;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class RegresionLinearMultiple {
    double sistemaEcuaciones[][]; //matriz para almacenar el sistema de ecuaciones
    double puntosx1[];
    double puntosx2[];
    double puntosy[];
    double sumax1 = 0, sumax2 = 0,sumay=0, sumax12=0, sumax22=0, sumax1x2=0,sumax1y=0, sumax2y=0;
    
    int numeroElementos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RegresionLinearMultiple regresion = new RegresionLinearMultiple();
        regresion.leePuntos();
        regresion.regresionLinearMultiple();
        regresion.gaussJordan();
        regresion.despliegaSolucion();
        
        
    }
    
    
    public void leePuntos() {

        Scanner tec = new Scanner(System.in);
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — —| REGRESIÓN LINEAR MULTIPLE |— — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        System.out.println("Número de elementos: ");
        numeroElementos = tec.nextInt();
        
        puntosx1 = new double [numeroElementos];
        puntosx2 = new double [numeroElementos];
        puntosy = new double [numeroElementos];
        
        System.out.println("Ingrese las coordenadas de los elementos: ");
        for (int f = 0; f < numeroElementos; f++) { 
            System.out.println(" — — — — —| Coordenadas [" + (f + 1) + "] |— — — — — ");

                    System.out.println("x1:");
                    puntosx1[f] = tec.nextDouble();  
                    
                    System.out.println("x2:");
                    puntosx2[f] = tec.nextDouble();  
                    
                    System.out.println("y:");
                    puntosy[f] = tec.nextDouble();
                
            }
        }
        
    
    public void creaSumatorias() {
        
        
        for (int i = 0; i < puntosx1.length; i++) {
            sumax1 += puntosx1[i];
            sumax2 += puntosx2[i];
            sumax12 += Math.pow(puntosx1[i], 2);
            sumax22 += Math.pow(puntosx2[i], 2);
            sumax1x2 += (puntosx1[i] * puntosx2[i]);
            
            
            sumay += puntosy[i];
            sumax1y += (puntosx1[i] * puntosy[i]);
            sumax2y += (puntosx2[i] * puntosy[i]);
            
        }
   
    }
    
    public void creaMatrizSumatorias(){
        sistemaEcuaciones = new double [3][4];
        
        sistemaEcuaciones[0][0] = puntosx1.length;
        sistemaEcuaciones[0][1] = sumax1;
        sistemaEcuaciones[0][2] = sumax2;
        sistemaEcuaciones[0][3] = sumay;
        
        sistemaEcuaciones[1][0] = sumax1;
        sistemaEcuaciones[1][1] = sumax12;
        sistemaEcuaciones[1][2] = sumax1x2;
        sistemaEcuaciones[1][3] = sumax1y;
        
        sistemaEcuaciones[2][0] = sumax2;
        sistemaEcuaciones[2][1] = sumax1x2;
        sistemaEcuaciones[2][2] = sumax22;
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
    
    public void regresionLinearMultiple(){
        DecimalFormat formato = new DecimalFormat("0.####");//formato para los decimales de resultados. 
        creaSumatorias();
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — — — —| TABLA DE VALORES |— — — — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%5s %5s %5s %7s %6s %6s %5s %5s", "|x1|", "|x2|", "|y|", "|x1^2|", "|x2^2|", "|x1*x2|", "|x1*y|", "|x2*y|");
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        
        for (int i = 0; i < puntosx1.length; i++) {
            System.out.format("%4s %5s %5s %6s %6s %6s %6s %6s",
                    formato.format(puntosx1[i]), formato.format(puntosx2[i]), formato.format(puntosy[i]), formato.format(Math.pow(puntosx1[i], 2)),  formato.format(Math.pow(puntosx2[i], 2)),  formato.format(puntosx1[i]*puntosx2[i]),  formato.format(puntosx1[i] * puntosy[i]),  formato.format(puntosx2[i] * puntosy[i]) );
            System.out.println();  
        }
        
         System.out.println("---------------------------------------------------------------");
         System.out.format("%4s %5s %5s %6s %6s %6s %6s %6s",
                    formato.format(sumax1),formato.format(sumax2),formato.format(sumay),formato.format(sumax12),formato.format(sumax22),formato.format(sumax1x2),formato.format(sumax1y),formato.format(sumax2y) );
            System.out.println(); 
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        
        
        
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
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        System.out.println("Ecuación: ");
        System.out.println("y = " + sistemaEcuaciones[0][3] + " + " + sistemaEcuaciones[1][3] + "x + " + sistemaEcuaciones[2][3] + "x^2");
        System.out.println("");
    }
}
