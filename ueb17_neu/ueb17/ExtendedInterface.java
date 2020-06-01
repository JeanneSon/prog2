import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
/**
 * Tragen Sie hier eine Beschreibung des Interface ExtendedInterface ein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public interface ExtendedInterface extends MyFunction
{
    /**
     * Méthode conditionateInput
     *
     * @return La valeur de retour
     */
    default MyFunction conditionateInput(IntPredicate p) {
        return x -> (p.test(x)) ? apply(x) : 0; 
    }
    
    /**
     * Méthode conditionateOutput
     *
     * @return La valeur de retour
     */
    default MyFunction conditionateOutput(IntPredicate p){
        return x -> {
            int applied = apply(x);
            return (p.test(applied)) ? applied : 0;
        };
    }
    
    
}
