public class Mitarbeiter extends Person
{
    // Objektattribute
    private String email;
    
    //Konstanten
    // Fehlermeldungen
    private static final String LEERE_EMAIL = "Bitte die E-Mail angeben!";

    /**
     * Konstruktor
     */
    public Mitarbeiter(String vorname, String nachname, String email)
    {
        super(vorname, nachname);
        email = email.trim();
        check(email != null && email != "", LEERE_EMAIL);
        this.email = email;
    }

    //Methoden
    /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    @Override
    public String toString()
    {
        return super.toString()  + " (" + email + ")";
    }

    //get-Methoden
    /**
     * Methode getEmail
     *
     * @return die Email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Methode equals
     * 
     * @param object o
     * @return true oder false
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Mitarbeiter) {
            Mitarbeiter p = (Mitarbeiter)o;
            return (super.equals(o) && email == p.email);
        } else
            return false;
    }

    /**
     *
     * @param
     * @return
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung)
    {

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
                