import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

//+++++++++++++++++++++++++++++++++Aufgabe 1c+++++++++++++++++++++++++++++++++++++++++
/**
 * Das Interface ExtendedInterface erweitert das Interface MyFunction.
 * 
 * @author VENET Aurianne & SCHALL Hanna
 * @version 1.0
 */

public interface ExtendedInterface extends MyFunction
{
    /**
     * Default-Methode conditionateInput nimmt ein Praedikat als Argument entgegen und gibt einen Lambda-Ausdruck zurueck. 
     * Der Lambda-Ausdruck prueft für einen gegebenen Integer-Wert, ob dieser das Praedikat erfuellt. 
     * Ist das Praedikat erfuellt, wird das Ergebnis der apply-Methode des Interfaces zurueckgegeben, ansonsten wird 0 zurückgegeben. 
     *
     * @return Lambda-Ausdruck
     */
    default MyFunction conditionateInput(IntPredicate p) {
        return x -> (p.test(x)) ? apply(x) : 0; 
    }
    
    /**
     * Default-Methode conditionateOutput nimmt ebenfalls ein Praedikat als Argument entgegen und gibt einen Lambda-Ausdruck zurueck. 
     * Der Lambda-Ausdruck prueft, ob das Ergebnis der apply-Methode das Prädikat erfuellt. 
     * Ist das Prädikat erfuellt, wird das Ergebnis zurückgegeben, ansonsten 0.
     *
     * @return Lambda-Ausdruck
     */
    default MyFunction conditionateOutput(IntPredicate p){
        return x -> {
            int applied = apply(x);
            return (p.test(applied)) ? applied : 0;
        };
    }
    
    
}
