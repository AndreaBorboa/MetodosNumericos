
package reglaRectangulo;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author andre
 */
public class ReglaRectangulo {
    double xini=0, xfin=0, incremento=0;
    double xi=Math.PI, xf=0;
    double x[],xmedia[],fxmedia[];
    int renglones;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ReglaRectangulo rectangulo = new ReglaRectangulo();
        rectangulo.tabula();
    }
    
    public void tabula(){
        DecimalFormat formato = new DecimalFormat("0.######");//formato para los decimales de f(x)
        reglaRectangulo();
        System.out.printf("%2s %14s %12s", "x", "xmedia", "f(xmedia)");
        System.out.println();
        System.out.println("-----------------------------------");
        
        double sum=0;
        for(int i=0; i<renglones+1; i++){
            System.out.format("%2s %10s %10s", formato.format(x[i]), formato.format(xmedia[i]), formato.format(fxmedia[i]));
            sum+=fxmedia[i];
            System.out.println(); 
        }
        
        System.out.println();
        double x0=(xi-xf)/xfin;
        System.out.println("Sumatoria: "+formato.format(sum));
        System.out.println("Area: "+formato.format(x0*sum));
    }
    
    public void reglaRectangulo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor de n inicial: ");
        xini = scanner.nextDouble();
        System.out.print("Valor de n final: ");
        xfin = scanner.nextDouble();
        System.out.print("Valor del incremento para n: ");
        incremento = scanner.nextDouble();
        
        renglones = (int) Math.round((xfin/incremento+1)-xini);
        x = new double[renglones+1];
        xmedia= new double[renglones+1];
        fxmedia= new double[renglones+1];
        
        x[0]=xf;
        
        for (int i=1; i<renglones+1; i++){
            double x0=(xi-xf)/xfin;
            x[i]=(xf+i)*(x0);
        }
        
        xmedia[0]= ((0+x[0])/2);
        
        for (int i=1; i<renglones+1; i++){
            xmedia[i]=(x[i-1]+x[i])/2;
        }
        
        fxmedia[0]=xf;
        for (int c=1; c<renglones+1; c++ ){
            fxmedia[c]=f(xmedia[c]);
        }
    }
    
    
    
    public static double f(double xm){
        double fxm = (8 + (5*Math.sin(xm)));
        
        return fxm;
    }
    
}
