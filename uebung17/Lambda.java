import java.lang.Math;
/**
 * Décrivez votre classe Lambda ici.
 *
 * @author  VENET Aurianne SCHALL Hanna
 * @version 1.0
 */
public class Lambda
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * konstrctor
     */
    public Lambda()
    {
    }
    static MyFunction quadrat = (int n) -> (int) Math.pow(n, 2);
    static MyFunction fakultaet = (int n) -> n <= 0 ? 1 : n * Lambda.fakultaet.apply(n - 1);
    static MyFunction fibonacci = (int n) -> ((n == 0) || (n == 1)) ? n : Lambda.fibonacci.apply(n-1) + Lambda.fibonacci.apply(n-2);
    static MyFunction exponent = (int n) -> (int) Math.pow(n, n+1);
}
