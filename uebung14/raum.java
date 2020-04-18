/**
 * @author A. Venet und H. Schall 
 * @version 1.0
 */
public class Raum
{
    //Konstanten
    private static final int TIEFSTER_KELLER = -2;
    private static final int MAX_ANZ_RESERVIERUNGEN = 20;
    
    // Attribute
    private int geb;
    private int etage;
    private int raum;
    private Reservierung[] reservierungen = 
                new Reservierung[MAX_ANZ_RESERVIERUNGEN];
    private int anzReservierungen = 0;
    
    
    // Fehlermeldungen
    private static final String MSG_RAUM_EXISTIERT_NICHT = 
        "Dieser Raum existiert nicht";
    private static final String MSG_RESERVIERUNGEN_VOLL = 
        "Die maximale Anzahl an Reservierungen ist bereits erreicht.";
    private String MSG_INDEX =
        "Index liegt nicht zwischen 0 und ";
        
    /**
     * Konstruktor für Objekte der Klasse Raum
     * @param 
     */
    public Raum(int geb, int etage, int raum)
    {
        check(
            geb >= 1 && 
            etage >= TIEFSTER_KELLER && 
            raum > 0, 
            MSG_RAUM_EXISTIERT_NICHT);
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    //Methoden
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    @Override
    public String toString()
    {
        StringBuilder sb = 
            new StringBuilder("Raum " + geb + "-" + etage + "." + raum);
        for (int i = 0; i < anzReservierungen; i++) {
            sb.append(
                "\ngebucht von " + 
                reservierungen[i].getMitarbeiter() + 
                reservierungen[i]);
        } 
        return sb.toString();
    }

    //get-Methoden
    /**
     * Methode getGeb
     *
     * @return das Gebaeude
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
     * @param  addReservierung
     */
    public void addReservierung(Reservierung reservierung)
    {
        check(anzReservierungen < MAX_ANZ_RESERVIERUNGEN,
                    MSG_RESERVIERUNGEN_VOLL);
        reservierungen[anzReservierungen] = reservierung;
        anzReservierungen++;
    }
    
    /**
     * @param  reservierung
     * @return 
     */
    public Reservierung getReservierung(int index)
    {
        check(0 <= index && index < anzReservierungen, 
            MSG_INDEX + anzReservierungen);
        return reservierungen[index];
    }
    
    /**
     * 
     * @return 
     */
    public int getAnzahlReservierung()
    {
        return anzReservierungen;
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
    private static void check(boolean bedingung, String msg) 
    throws IllegalArgumentException
    {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
