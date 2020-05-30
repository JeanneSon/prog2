import java.lang.Math;
/**
 * NumberCruncherAnonym
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class Anonym
{
    //Klassenkonstanten
    
    
    //Objektattribute
   
    
    /**
    * Konstruktor
    * @param 
    */
    public Anonym()
    {
    }
    public void anonymeKlassen(){
        MyFunction quadrat = new MyFunction(){
                public int apply(int n) {
                    return (int) Math.pow(n, 2);
                }
            };
        MyFunction fakultaet = new MyFunction(){
                public int apply(int n) {
                    if (n <= 0)
                        return 1;
                    else
                        return n * apply(n-1);
                }
            };      
        MyFunction fibonacci = new MyFunction(){
                public int apply(int n) {        
                    if ((n == 0) || (n == 1))            
                        return n;        
                    else            
                        return apply(n-1) + apply(n-2);    
                }
            };
        MyFunction exponent = new MyFunction(){
                public int apply(int n) {        
                    return (int) Math.pow(n, n+1);    
                }
            };
    }

    /**
    * Methode toString
    * @return informiert ueber die Klasse NumberCruncherAnonym
    */ 
    public String toString() {
        return " ";
    }
}