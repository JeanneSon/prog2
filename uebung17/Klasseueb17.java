
/**
 * Décrivez votre classe Klasseueb17 ici.
 *
 * @author  VENET Aurianne SCHALL Hanna
 * @version 1.0
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
    
    
    public static class Fakultaet{
        public int fakultaet(int n){
            if (n <= 0)
            return 1;
            else
            return n * fakultaet(n-1);
        }
    }
}
