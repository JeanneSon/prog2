import java.util.function.Predicate; 
/**
 * Décrivez votre interface Conditionate ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */

public interface Conditionate extends MyFunction
{
    
    /**
     * Méthode conditionateInput
     *
     * @return La valeur de retour
     */
    int conditionateInput(Predicate predic);
    
    /**
     * Méthode conditionateOutput
     *
     * @return La valeur de retour
     */
    int conditionateOutput(Predicate predic);
    
    Predicate<Integer> even = i -> ((i % 2) == 0);
    Predicate<Integer> odd = i -> ((i % 2) /= 0);
}
