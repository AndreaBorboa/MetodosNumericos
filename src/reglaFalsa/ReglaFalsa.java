package reglaFalsa;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andrea Borboa Ramírez
 */
public class ReglaFalsa {

    /**
     * Programa que calcula la raiz por el metodo de regla falsa para la función f(x)=(1-0.6x)/x
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //Se solicitan los datos del valor de x izquierda, x derecha y el error. 
    System.out.print("Valor de x izquierda: ");
    double xizq = scanner.nextDouble();
    System.out.print("Valor de x derecha: ");
    double xder = scanner.nextDouble();
    System.out.print("Error: ");
    double error = scanner.nextDouble();
    
        reglaFalsa(xizq, xder, error);
    
    }
    
    private static void reglaFalsa(double xizq, double xder, double error){
        DecimalFormat formato = new DecimalFormat("0.####");//formato para los decimales de resultados. 
        
        
        double xm = 0;
        double fxm=0;
        
        double fxder=f(xder);
        double fxizq=f(xizq);
        
        xm = ((xizq*fxder)- (xder*(fxizq))) / (fxder - fxizq); // calcula xm
        fxm=f(xm); //obtiene f(xm) llamando al metodo "f" y enviando como parametro xm
        
        
        //Encabezado de la tabla para los resultados 
        System.out.println("─♡──────────────────────────────────────♡─");
        System.out.printf("%10s %10s %10s %10s %10s %10s", "xi", "xd", "f(xi)", "f(xd)","xm","f(xm)");
        System.out.println();
        System.out.println("─♡──────────────────────────────────────♡─");
        
        //Ciclo que se repite mientras el valor absoluto de f(xm) sea mayor al error. 
        while(Math.abs(fxm)>error){
            
            fxizq = f(xizq); // se calcula f(xizq) llamando al metodo "f"
            fxder = f(xder);// se calcula f(xder) llamando al metodo "f"
            xm = ((xizq*fxder)- (xder*(fxizq))) / (fxder - fxizq); // calcula xm
            fxm=f(xm);// calcula f(xm) llamando al metodo "f"
            
            //Se imprimen los resultados en la tabla con el formato indicado.
            System.out.format("%10s %10s %10s %10s %10s %10s",
                    formato.format(xizq),formato.format(xder),formato.format(fxizq),formato.format(fxder),formato.format(xm),formato.format(fxm));
            System.out.println();
            
           
            //condicion para reemplazar x izquiera o x derecha segun sea el caso. 
            if(fxm<0){
                if(fxizq<0){
                    xizq=xm;
                }else{
                    xder=xm;
                }
               
            }else{
                if(fxizq>0){
                    xizq=xm;
                }else{
                    xder=xm;
                }
                
            } 
        }
        System.out.println("─♡──────────────────────────────────────♡─");
        
    }
    
     //Metodo que calcula la funcion solicitada 
    private static double f(double x) {
        return ( 1 - 0.6 * (x)) / x;
    }
    
}
