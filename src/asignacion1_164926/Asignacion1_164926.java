
package asignacion1_164926;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author AndreaBorboa
 */
public class Asignacion1_164926 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         //variables
        
        double x=1;
        Scanner scanner = new Scanner(System.in);
        
        
        
        System.out.print("Valor de X inicial: ");
        double xini = scanner.nextDouble();
        System.out.print("Valor de X final: ");
        double xfin = scanner.nextDouble();
        System.out.print("Valor del incremento para x: ");
        double incremento = scanner.nextDouble();
        
        
        double fxfin=f(xfin);
        double fxini=f(xini);
        double fx=fxfin; 
        
        DecimalFormat formato = new DecimalFormat("#.0");
        DecimalFormat formato1 = new DecimalFormat("#.000");
        
        System.out.println("f(xini): "+fxini+"  f(xfin): "+fxfin);
        System.out.println("x     f(x)");
        while(x<=xfin){
            fx=f(x);
            System.out.println(formato.format(x)+"   "+formato1.format(fx));
            x=x+incremento;
      
        }
    }

    //Metodo para calcular la funcion del ejemplo el clase.
     private static double f(double x) {
        return (Math.pow(x, 3) + (2 * Math.pow(x, 2)) + (7 * x) - 20);
    }
    
}
