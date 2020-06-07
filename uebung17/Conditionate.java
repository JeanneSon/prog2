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
     * conditionateInput Methode
     *
     * @return ein lambda ausdruck
     */
    public default MyFunction conditionateInput(Predicate<Integer> pred){
        MyFunction predicate_lambda = (int n) -> {
            if (pred.test(n)) {
                return this.apply(n);
            }else {
                return 0;
            }
        };
        return predicate_lambda;
    }
    
    /**
     * conditionateOutput Methode
     *
     * @return ein lambda ausdruck
     */
    public default MyFunction conditionateOutput(Predicate<Integer> pred){
        MyFunction predicate_lambda = (int n) -> {
            if (pred.test(this.apply(n))) {
                return this.apply(n);
            }else {
                return 0;
            }
        };
        return predicate_lambda;
    };
    
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
