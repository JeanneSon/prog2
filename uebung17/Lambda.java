import java.lang.Math;
/**
 * Décrivez votre classe Lambda ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Lambda implements Myfunction
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;

    /**
     * Constructeur d'objets de classe Lambda
     */
    public Lambda()
    {
        // initialisation des variables d'instance
        x = 0;
    }
    MyFunction quadrat = (int n) -> (int) Math.pow(n, 2);
    MyFunction fakultaet = (int n) -> (n<=0) ? 1 : n*fakultaet(n-1);
    MyFunction fibonacci = (int n) -> ((n == 0) || (n == 1)) ? n : fibonacci(n-1) + fibonacci(n-2);
    MyFunction exponent = (int n) -> (int) Math.pow(n, n+1);
}
