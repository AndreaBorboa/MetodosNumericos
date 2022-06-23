
package gaussSeidel;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Amdrea Borboa Ramírez
 */
public class GaussSeidel {

    double sistemaEcuaciones[][]; //matriz para almacenar el sistema de ecuaciones
    double error; //precisión que se desea obtener
    int iteraciones = 0; //numero actual de iteraciones
    double[] xactuales = new double[3]; //array que almacena las x_i de la iteracion actual
    double[] xanteriores = new double[3]; // array que almacena las x_i de la iteracion anterior
    double[] abs = new double[3]; // array que almacena los valores absolutos de las x_i
    
    
    
    //Programa que calcula los valores de x para solucionar el sistema de ecuaciones por el metodo de Gauss Seidel. 
    public static void main(String[] args) {
        GaussSeidel seidel= new GaussSeidel();
        seidel.leeEcuaciones();
        seidel.gaussSeidel();
    }

    public void leeEcuaciones() {//metodo para leer las ecuaciones y el error

        Scanner tec = new Scanner(System.in);

        this.sistemaEcuaciones = new double[3][4]; // se le da un tamaño a la matriz de 3 renglones por 4 columnas.

        System.out.println("Ingrese los valores de los coeficientes de las ecuaciónes: ");

        for (int f = 0; f < 3; f++) { //ciclo para leer el numero de la ecuacion que se solicita. 
            System.out.println("⚘ — — — — —| Ecuación [" + (f + 1) + "] |— — — — — ⚘");


            for (int c = 0; c < 3; c++) { // ciclo para leer los coeficientes.

                System.out.println("Coeficiente x" + (c + 1) + ":");
                this.sistemaEcuaciones[f][c] = tec.nextDouble();
            }


            System.out.println("Resultado de ecuación " + (f + 1) + ":"); // lee los "=" de cada ecuación. 
            this.sistemaEcuaciones[f][3] = tec.nextDouble();
        }
        
        System.out.println("————————— Error ————————");
        error = tec.nextDouble(); //solicita el error aproximado. 
    }

    public void gaussSeidel() {
        double x1=0, x2=0, x3=0; //inicializamos x1,x2 y x3 en 0.
        abs[0]=1; //inicializamos los valores de valor absoluto para que pueda entrar al ciclo. 
        abs[1]=1;
        abs[2]=1;
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("⚘ — — — — — — — — — — | METODO GAUSS SEIDEL |— — — — — — — — — — ⚘");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        

            
        while ( (Math.abs(abs[0])) > error && (Math.abs(abs[1])) > error && (Math.abs(abs[2]))> error ) { //Se repite hasta que los valores absolutos de las x sean menores o iguales al error. 
            
            //Se calcula x1 y se almacena en el arreglo de las x actuales para utilizarla en x2 y x3.
            x1 = this.sistemaEcuaciones[0][3] + ( ( (this.sistemaEcuaciones[0][1]) * (-1)) * (xanteriores[1])) + (  ( (this.sistemaEcuaciones[0][2]) * (-1) )  * (xanteriores[2]) ) ;
            if (this.sistemaEcuaciones[0][0]<0){
                x1 = (x1) / ( (this.sistemaEcuaciones[0][0])* -1);
            }else{
                x1 = x1 / this.sistemaEcuaciones[0][0];
            }
            xactuales[0] = x1;
           
            //Se calcula x2 y se almacena en el arreglo de las x actuales para utilizarla en x3. 
            x2 = this.sistemaEcuaciones[1][3] + ( ( (this.sistemaEcuaciones[1][0]) * (-1)) * (xactuales[0])) + ( ( (this.sistemaEcuaciones[1][2]) * (-1)) * (xanteriores[2]) ) ;
            if (this.sistemaEcuaciones[1][1]<0){
                x2 = (x2) / ( (this.sistemaEcuaciones[1][1])* -1);
            }else{
                x2 = x2 / this.sistemaEcuaciones[1][1];
            }
            xactuales[1]=x2;
            
            //Se calcula x3 y se almacena en el arreglo de las x actuales para utilizarla en x1.  
            x3 = this.sistemaEcuaciones[2][3] + ( ( (this.sistemaEcuaciones[2][0]) * (-1)) * (xactuales[0])) + ( ( (this.sistemaEcuaciones[2][1]) * (-1)) * (xactuales[1]) );
            if (this.sistemaEcuaciones[2][2]<0){
                x3 = (x3) / ( (this.sistemaEcuaciones[2][2])* -1);
            }else{
                x3 = x3 / this.sistemaEcuaciones[2][2];
            }
            xactuales[2]=x3;
            
            //Se hacen las restas de la x actual - la x anterior y se almacenan en el arreglo de abs para ser utilizado en la impresion. 
            abs[0] = xactuales[0] - xanteriores[0];
            abs[1] = xactuales[1] - xanteriores[1];
            abs[2] = xactuales[2] - xanteriores[2];
            
            //Ahora las x anteriores van a ser igual a las x actuales. 
            xanteriores[0] = xactuales[0];
            xanteriores[1] = xactuales[1];
            xanteriores[2] = xactuales[2];
            
            despliegaSolucion(); //llamamos al metodo despliegaSolucion() para imrpimir las x actuales y los valores absolutos. 
            
            
            iteraciones++; //incrementamos el numero de iteraciones
        }
        
    }
    
    public void despliegaSolucion(){ //metodo para imrpimir los valores de las x y valores absolutos de las x. 
        DecimalFormat formato = new DecimalFormat("0.######"); //formato para la impresion. 
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Iteración: "+iteraciones+" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"); //imrpimimos el numero de la iteracion actual. 
        
        System.out.println("");
        
        //ciclo para imprimir los valores de x
        for(int i =0; i<xanteriores.length; i++){
            System.out.println("x"+ (i+1) +": "+formato.format(xanteriores[i]));
        }
        
        System.out.println("");
        //ciclo para imprimir los valores absolutos de las x. 
        if(iteraciones>0){
            for(int i =0; i<abs.length; i++){
                System.out.println("Valor absoluto x"+ (i+1) +": "+formato.format(abs[i]));
            }  
        }
        
        
        
    }




}