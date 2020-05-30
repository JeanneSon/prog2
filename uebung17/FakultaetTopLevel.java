
/**
 * TopLevel Klasse für Fakultät.
 * 
 * @author VENET Aurianne & SCHALL Hanna 
 * @version 1.0
 */
public class FakultaetTopLevel
{
    /**
     * Methode, die die Fakultät eines übergebenen ins berechnet
     * 
     * @param  n    übergebenes int
     * @return        Fakultät von n
     */
    public int fakultaet(int n)
    {
        if (n <= 0)
            return 1;
        else
            return n * fakultaet(n-1);
    }
}