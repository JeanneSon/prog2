//+++++++++++++++++++++++++++++++Aufgabe 1b+++++++++++++++++++++++++++

/**
 * TopLevel Klasse fuer Fakultaet.
 * 
 * @author VENET Aurianne & SCHALL Hanna 
 * @version 1.0
 */
public class FakultaetTopLevel
{    
    /**
     * Methode, die die Fakultaet eines uebergebenen int berechnet
     * 
     * @param  n    uebergebenes int
     * @return        Fakultaet von n
     */
    public int fakultaet(int n)
    {
        if (n <= 0)
            return 1;
        else
            return n * fakultaet(n-1);
    }
    
    /**
     * Methode toString informiert ueber die Klasse
     *
     * @return Info-String
     */
    @Override
    public String toString() {
        return "Die in Aufgabe 1b von Ueb 17 beschriebene TopLevel-Klasse";
    }
}
