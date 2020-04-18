/**
 * Klasse Uhrzeit
 * 
 * @author A. Venet and H. Schall 
 * @version 1.0
 */
public class Uhrzeit
{
    // Objektattribute
    private int stunde;
    private int minute;

    //Konstanten
    public static final int MINUTE_MIN = 0;
    public static final int MINUTE_MAX = 59;
    public static final int STUNDE_MIN = 0;
    public static final int STUNDE_MAX = 23;

    // Fehlermeldungen
    private static final String MSG_STUNDE = "Die Stunden muessen zwischen " + STUNDE_MIN + " und " + STUNDE_MAX + " sein!";
    private static final String MSG_MINUTE = "Die Minuten muessen zwischen " + MINUTE_MIN + " und " + MINUTE_MAX + " sein!";

    /**
     * Konstruktor fuer Objekte der Klasse Uhrzeit
     * 
     * @param stunde muss zwischen 0 und 23 sein
     * @param muss zwischen 0 und 59 sein
     */

    public Uhrzeit(int stunde, int minute) throws IllegalArgumentException
    {
        check( stunde >= STUNDE_MIN &&
            stunde <= STUNDE_MAX, MSG_STUNDE);
        check( minute >= MINUTE_MIN &&
            minute <= MINUTE_MAX, MSG_MINUTE);
            
        this.stunde = stunde;
        this.minute = minute;
    }

    //Methoden
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    @Override
    public String toString()
    {
        return stunde + ":" + minute + " Uhr";
    }

    //get-Methoden
    /**
     * Methode getStunde
     *
     * @return die Stunde
     */
    public int getStunde()
    {
        return stunde;
    }

    /**
     * Methode getMinute
     *
     * @return die Minute
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * equals prueft zwei Uhrzeiten auf Gleichheit
     * 
     * @param o muss ein gueltiges Uhrzeit-Objekt referenzieren
     * @return  true, falls o ein Uhrzeit-Objekt ist und inhaltlich gleich zu this
     *          false sonst
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Uhrzeit) {
            Uhrzeit p = (Uhrzeit)o;
            return (stunde == p.stunde && minute == p.minute);
        } else
            return false;
    }

    /**
     * isLater prueft ob die uebergebene Uhrzeit frueher ist
     * 
     * @param   true, falls o ein Uhrzeit-Objekt ist und this spaeter ist
     *          false sonst
     */
    public boolean isLater(Object o) {
        if (o instanceof Uhrzeit) {
            Uhrzeit u = (Uhrzeit)o;
            return stunde > u.stunde || 
                        (stunde == u.stunde && minute > u.minute);
        } else
            return false;
    }
    
    //Allgemeine Methode zur Ueberpruefung
    /**
     * Methode check wirft eine IllegalArgumentException, falls bedingung nicht erfuellt
     *
     * @param bedingung 
     * @param msg - Fehlermeldung
     */
    public static void check(boolean bedingung, String msg) throws IllegalArgumentException
    {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
