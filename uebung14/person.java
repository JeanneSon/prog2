/**
 * Klasse Person.
 * 
 * @author A. Venet and H. Schall 
 * @version 1.0
 */
public class Person
{
    // Objektattribute
    private String vorname;
    private String nachname;

    // Fehermeldungen
    private static final String LEERER_VORNAME = "Bitte den Vornamen angeben!";
    private static final String LEERER_NACHNAME = "Bitte den Nachnamen angeben!";
    
    
    /**
     * Konstruktor 
     * 
     * @param vorname muss mind. der Laenge 1 sein
     * @param nachname muss mind. der Laenge 1 sein
     */
    public Person(String vorname, String nachname) throws IllegalArgumentException
    {
        vorname = vorname.trim();
        nachname = nachname.trim();
        
        check(vorname != null && !vorname.isEmpty(), LEERER_VORNAME);
        check(nachname != null && !nachname.isEmpty(), LEERER_NACHNAME);
        
        this.vorname = vorname;
        this.nachname = nachname;
    }

    
    //get-Methoden
    public String getVorname() 
    {
        return vorname;
    } 
    
    public String getNachname() 
    {
        return nachname;
    } 
    
   
    /**
     * equals prueft zwei Personen auf Gleichheit
     * 
     * @param o muss ein gueltiges Person-Objekt referenzieren
     * @return  true, falls o ein Person-Objekt ist und inhaltlich gleich zu this
     *          false sonst
     */
    @Override
    public boolean equals(Object o) 
    {
        if (o == null) return false;
        if (o instanceof Person) {
            Person p = (Person)o;
            return (vorname.equals(p.vorname) && nachname.equals(p.nachname));
        } else
            return false;
    } 

    
    /**
     * Methode toString
     * 
     * @return Aufbereitung des Objekts als Zeichenkette
     */
    @Override
    public String toString()
    {
        return vorname + " " + nachname;
    }

    //Allgemeine Methode zur Ueberpruefung
    /**
     * Methode check wirft eine IllegalArgumentException, falls bedingung nicht erfuellt
     *
     * @param bedingung 
     * @param msg - Fehlermeldung
     */
    private static void check(boolean bedingung, String msg) throws IllegalArgumentException
    {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
