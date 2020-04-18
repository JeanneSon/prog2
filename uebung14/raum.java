/**
 * @author A. Venet und H. Schall 
 * @version 1.0
 */
public class Raum
{
    // Attribute
    private int geb;
    private int etage;
    private int raum;
    
    //Konstanten
    
    // Fehlermeldungen
    
    
    /**
     * Konstruktor für Objekte der Klasse Raum
     * @param 
     */
    public Raum(int geb, int etage, int raum)
    {
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    //Methoden
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    public String toString()
    {
        return "Raum " + geb + "-" + etage + "." + raum;
    }

    //get-Methoden
    /**
     * Methode getGeb
     *
     * @return die Geb
     */
    public int getGeb()
    {
        return geb;
    }

    /**
     * Methode getEtage
     *
     * @return die Etage
     */
    public int getEtage()
    {
        return etage;
    }
    
    /**
     * Methode getRaum
     *
     * @return die Raum
     */
    public int getRaum()
    {
        return raum;
    }
    
    /**
     * @param  reservierung
     * @return 
     */
    public void addReservierung(Reservierung reservierung)
    {
        
    }
    
    /**
     * @param  reservierung
     * @return 
     */
    public Reservierung getReservierung(int index)
    {
        
    }
    
    /**
     * @param  reservierung
     * @return 
     */
    public int getAnzahlReservierung()
    {
        
    }

    /**
     * Methode equals
     * @param object o
     * @return true wenn die 2 object gleich sind sondern false  
     */
    public boolean equals(Object o) {
        if (o instanceof Raum) {
            Raum p = (Raum)o;
            return (geb == p.geb && etage == p.etage && raum == p.raum);
        } else
            return false;
    } 

    //Allgemeine Methode zur Ueberpruefung
    /**
     * Methode check
     *
     * @param bedingung, die erfuellt werden soll
     * @param msg (Fehlermeldung)
     */
    public static void check(boolean bedingung, String msg)
    {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
