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
    private static final String OPERATION_NOT_VALID = "Ungueltige Operation: ";
    //Objektattribute
   
    
    /**
    * Konstruktor
    * @param 
    */
    public Anonym()
    {
        
    }
    public static int fibonacci(int n)
    {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static int fakultaet(int n){
        if (n <= 0)
            return 1;
        else
            return n * fakultaet(n-1);
    }
    
    public static int quadrat(int n){
        return (int) Math.pow(n, 2);
    }
    
    public static int exponent(int n) {
        return (int) Math.pow(n, n+1);
    }
    
    /**
    * Methode toString
    * @return informiert ueber die Klasse NumberCruncherAnonym
    */ 
    public String toString() {
        return " ";
    }
}