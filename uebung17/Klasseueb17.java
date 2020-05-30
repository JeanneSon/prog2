
/**
 * Décrivez votre classe Klasseueb17 ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Klasseueb17
{
    
    /**
     * Constructeur d'objets de classe Klasseueb17
     */
    public Klasseueb17()
    {
        
    }

    
    /**
     * Méthode applyAndPrint
     *
     * @param i 
     * @param j 
     * @param predicate
     * @return ein liste von number zwischen i und j die dem Predicate ???
     */
    public int[] applyAndPrint(int i, int j)
    {
        int[] result;
        for(int x = i+1; x<j; x++){
            result.add(apply(x));
        }
        return result;
    }
    
    public static class Fakultaet{
        public int fakultaet(int n){
            if (n <= 0)
            return 1;
            else
            return n * fakultaet(n-1);
        }
    }
}
