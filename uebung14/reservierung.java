/**
 * @author A. Venet und H. Schall 
 * @version 1.0
 */
public class Reservierung
{
    // Attribute
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    
    //Konstanten
    
    // Fehlermeldungen
    private static final String MSG_ZEIT = "Der beginn muss kleiner als der ende sein!";

    /**
     * Konstruktor für Objekte der Klasse Reservierung
     * @param 
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
        this.beginn = beginn;
        this.ende = ende;
    }

    //Methoden
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    public String toString()
    {
        return "reservierung";
    }

    //get-Methoden
    
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
