import java.util.function.Predicate; 
/**
 * Décrivez votre interface Conditionate ici.
 *
 * @author  VENET Aurianne SCHALL Hanna
 * @version 1.0
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
    
    Predicate<Integer> even = i -> i % 2 == 0;
    //System.out.println(even.test(33)) -> False
    //Predicate<Integer> odd = i -> ((i % 2) /= 0);
    public interface OddInterface{
        public boolean oddTest(int i);
    }
    OddInterface odd =  new OddInterface(){
            public boolean oddTest(int i){
                return i % 2 != 0;
            }
        };
}
