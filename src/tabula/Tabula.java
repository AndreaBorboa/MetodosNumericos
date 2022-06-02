package tabula;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class Tabula {
    public static void main(String[] args) {
        /**
        * Programa que calcula los valotrs de f(x) y los muestra en una tabla dependiendo de xinicial y xfinal e incremento
        * que indica el usuario por teclado. 
        */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor de X inicial: ");
        double xini = scanner.nextDouble();
        System.out.print("Valor de X final: ");
        double xfin = scanner.nextDouble();
        System.out.print("Valor del incremento para x: ");
        double incremento = scanner.nextDouble();
        
        tabula(xini, xfin, incremento);
        
    }
    
     //Metodo para calcular la funcion del ejemplo el clase.
     private static double f(double x) {
        return (Math.pow(x, 3) + (2 * Math.pow(x, 2)) + (7 * x) - 20);
    }
    
     
      //Metodo para crear la tabla con los valores de f(x)
     private static void tabula(double xini, double xfin, double incremento) {
        double x=1;
        double fxfin=f(xfin);//calcula la f(xfin)
        double fxini=f(xini);//calcula la f(xini)
        double fx=fxfin; 
        
        DecimalFormat formato = new DecimalFormat("#.0");//formato para los decimales de x
        DecimalFormat formato1 = new DecimalFormat("#.0000");//formato para los decimales de f(x)
        
        System.out.println("f(xini): "+fxini+"  f(xfin): "+fxfin);//imprime los valores de f(xini) y f(xfin)
        System.out.println("x     f(x)");//encabezados de la tabla
        while(x<=xfin){//mientras que el valor de x sea menor o igual que el valor de xfinal  calcular f(x) y añade un incremento en x.
            fx=f(x);
            System.out.println(formato.format(x)+"   "+formato1.format(fx));
            x=x+incremento;
      
        }
        
        
    }
    
    
}
