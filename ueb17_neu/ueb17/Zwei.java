import java.util.function.IntPredicate; 
/**
 * Beschreiben Sie hier die Klasse Zwei.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Zwei
{
    IntPredicate even = i -> i % 2 == 0;
    
    IntPredicate odd = new IntPredicate() {
        public boolean test(int n) {        
            return n % 2 != 0;    
        }
    };
}
