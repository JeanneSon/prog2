import java.math.BigDecimal;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Beschreiben Sie hier die Klasse MathFunctions.
 * 
 * @author A. Venet und H. Schall
 * @version 1.0
 */
public class MathFunctions
{
    //Klassenkonstanten
    public static final int KLEINSTE_ISBN = 100_000_000;
    public static final int GROESSTE_ISBN = 999_999_999;
    private static final double EPSILON = 10e-6;

    /**
     * berechneTeilersumme addiert alle Teiler
     *
     * @param Zahl muss positiv sein
     * @return Teilersumme
     */
    public static long berechneTeilersumme (long zahl) {
        check(zahl > 0,
        "Der Zahl muss positiv sein");
        long teilersumme = zahl + 1;
        long j;
        for(int i = 2; i <= sqrt(zahl); i++) {
            if (zahl % i == 0) {
                j = zahl / i;
                teilersumme += i + j;
            }
        }
        if (zahl % sqrt(zahl) == 0)
            teilersumme -= sqrt(zahl);
        return teilersumme;
    }

    /**
     * berechneChecksummeIsbn berechnet die Pruefziffer einer ISBN
     *
     * @param isbn muss 9-stellig sein
     * @return String der Pruefziffer
     */
    public static String berechneChecksummeIsbn(long isbn) {
        String ergebnis = "ISBN nicht gueltig.";
        long summe = 0L;
        // ueberpruefen, ob isbn 9-stellig ist
        if (isbn >= KLEINSTE_ISBN && isbn <= GROESSTE_ISBN) {
            for(long i = 9; i > 0; i--) {
                summe += isbn % 10 * i;
                isbn /= 10; // isbn = isbn / 10
            }
            summe %= 11;
            if (summe == 10)
                return "X";
            return Long.toString(summe);
        }
        return "ISBN nicht gueltig.";
    }


    /**
     * berechneNullstellen berechnet die Nullstellen von p und q
     * x <sup>2</sup> + p*x +q = 0
     * @param p  sowie p*x<sup>1</sup>
     * @param q  sowie q*x<sup>0</sup>
     * @return String, der ueber die Nullstellen informiert
     */
    public static String berechneNullstellen(double p, double q){
        double p2 = p/2.0;
        double diskriminante = (p2) * (p2) - q;
        if (diskriminante < -EPSILON){
            return "Komplexe Nullstellen";
        }
        else if(diskriminante <= EPSILON && diskriminante >= -EPSILON){
            double x1 = -p2;
            return "Doppelte Nullstelle: " + x1;
        }
        else {
            double x1 = -p2 + Math.sqrt((p2) * (p2) - q);
            double x2 = -p2 - Math.sqrt((p2) * (p2) - q);
            return "Zwei Nullstellen: " + x1 + " | " + x2;
        }
    }
    
    /**
     * istSummeVonPotenzen 
     *
     * @param muss positiv sein
     * @return true wenn a<sup>4</sup> + b<sup>3</sup> + c<sup>2</sup> = n existiert, anderfalls false
     */
    public static boolean istSummeVonPotenzen(long n){
        // darstellbar als a^4, b^3, c^2
        check(n > 0, "Die Zahl muss positiv sein");
        long summand1, summand2;
        for (long a = 1; a <= Math.sqrt(Math.sqrt(n - 2)); a++){
            summand1 = a*a*a*a;
            //Math.sqrt(n) // 2 - 1      summe = a*a + a*a + 1 -> wurzel((summe - 1) / 2)
            for (long b = 1; b <= Math.cbrt(n - 2); b++) {
                summand2 = b*b*b;
                for (long c = 1; c <= Math.sqrt(n - 2); c++) {
                    if (n - summand1 - summand2 == c*c) {
                        System.out.println("a : " + a + ", b : " + b + ", c : " + c);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * berechneReihensumme
     *
     * @param n muss positiv sein 
     * @param x Anzahl der Iterationen 
     * @return die reihensumme
     */
    public static double berechneReihensumme(int n, double x){
        check(n > 0, "Die Zahl n muss positiv sein");
        double reihensumme = 0;
        double zaehler = 1;
        for (int i = 1; i <= n; i++){
            zaehler *= (x - 1);
            reihensumme += zaehler / (i*pow(x, i));
        }
        return reihensumme ;
    }
    
    
    //Allgemeine Methode zur Ueberpruefung
    /**
    * Methode check
    *
    * @param Bedingung, die erfuellt werden soll
    * @param msg (Fehlermeldung)
    */
    public static void check(boolean bedingung, String msg)
    {
    if (!bedingung)
        throw new IllegalArgumentException(msg);
    }
}