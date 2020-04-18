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
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    
    //Konstanten
    
    // (Fehler-)meldungen
    private static final String MSG_ZEIT = 
        "Der Beginn muss vor dem Ende sein!";
    private static final String MSG_BEMERKUNG_ANGEBEN =
        "Bitte die Bemerkung angeben!";
    private static final String MSG_BEMERKUNG_FEHLT =
        "Die Bemerkung existiert noch nicht!";

    /**
     * Konstruktor
     * 
     * @param beginn
     * @param ende
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
        check(ende.isLater(beginn), MSG_ZEIT);
        this.beginn = beginn;
        this.ende = ende;
    }

    /**
     * Konstruktor, der alle moeglichen Attribute entgegen nimmt
     *
     * @param beginn
     * @param ende
     * @param raum
     * @param mitarbeiter
     * @param bemerkung
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende, Raum raum,
                            Mitarbeiter mitarbeiter, String bemerkung)
    {
        this(beginn, ende);
        setBemerkung(bemerkung);
        setMitarbeiter(mitarbeiter);
        setRaum(raum);
    }
    
    //Methoden
    //set-Methoden
    /**
     * setBemerkung weist der Reservierung eine Bemerkung zu
     * 
     * @param bemerkung darf nicht null und nicht leer sein
     */
    public void setBemerkung(String bemerkung) 
    {
        bemerkung = bemerkung.trim();
        check(bemerkung != null && bemerkung != "", MSG_BEMERKUNG_ANGEBEN);
        this.bemerkung = bemerkung;
    }
    
    /**
     * setMitarbeiter weist der Reservierung einen Mitarbeiter zu
     * 
     * @param mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
    }
    
    /**
     * setRaum weist der Reservierung einen Raum zu
     * 
     * @param raum
     */
    public void setRaum(Raum raum)
    {
        this.raum = raum;
    }
    
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    @Override
    public String toString()
    {
        return "reservierung";
    }

    //get-Methoden
    public String getBemerkung()
    {
        return bemerkungIsSet() ? bemerkung : MSG_BEMERKUNG_FEHLT;
    }
    
    
    //Allgemeine Methode zur Ueberpruefung
    /**
     * bemerkungIsSet
     * 
     * @return  true, falls Bemerkung gesetzt ist
     *          false sonst
     */
    private boolean bemerkungIsSet()
    {
        return bemerkung != null;
    }
    
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
