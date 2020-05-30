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
        return n^2;
    }
    
    public static int exp(int b) {
        int n = b+1;
        if (n == 0)
            return 1;
        else if (n % 2 == 0) {
            int l = exp(b, n / 2);
            return l * l;
        }else
            return b * exp(b, n - 1);
    }
    
    /**
    * Methode toString
    * @return informiert ueber die Klasse NumberCruncherAnonym
    */ 
    public String toString() {
        return "NumberCruncherAnonym kann Operationen ausfuehren.";
    }
}