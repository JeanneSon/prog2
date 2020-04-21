import java.util.*;
/**
* Interaktive Testklasse fuer die Klasse Reservierung
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class ReservierungDialog
{
    //Attribute
    private Uhrzeit uhrzeit;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    private Reservierung reservierung;
    private Scanner input = new Scanner(System.in);

    
    //Klassenkonstanten
    
    //Konstanten fuer das Auswahl-Menue
    private static final int RAUM_ANLEGEN = 1;
    private static final int MITARBEITER_ANLEGEN = 2;
    private static final int UHRZEIT_ANLEGEN = 3;
    private static final int RESERVIERUNG_ANLEGEN = 4;
    private static final int TO_STRING_RESERVIERUNG = 5;
    private static final int TO_STRING_RAUM = 6;
    private static final int TO_STRING_MITARBEITER = 7;
    private static final int TO_STRING_UHRZEIT = 8;
    private static final int ENDE = 0;
    
    //Konstanten fuer die Darstellung
    private static final String TRENNLINIE = 
        "-----------------------------------------------------------------------------------------";

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN IN IHRER RESERVIERUNG!");
        int auswahl = -1;

        while (auswahl != ENDE) {
            try {
                auswahl = einlesenAuswahl();
                ausfuehrenAuswahl(auswahl);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                input.nextLine();       //Absorption des "falschen" Tokens
            } catch (Exception e) {
                System.out.println("Achtung, gefangen Ausnahem: " + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
    * einlesenAuswahl Methode
    * Menue ausgeben und Auswahl einlesen
    *
    * @return eingelesene Auswahl als ganzzahliger Wert
    */
    private int einlesenAuswahl() {
        int auswahl;
        System.out.print(
        RAUM_ANLEGEN                    + ": Raum neu anlegen; \n" +
        MITARBEITER_ANLEGEN             + ": Mitarbeiter neu anlegen; \n" + 
        UHRZEIT_ANLEGEN                 + ": Uhrzeit neu anlegen  \n" +
        RESERVIERUNG_ANLEGEN            + ": Reservierung neu anlegen \n" +
        TO_STRING_RESERVIERUNG          + ": to String fur reservierung \n" +
        TO_STRING_RAUM                  + ": to String fur raum \n" +
        TO_STRING_MITARBEITER           + ": to String fur mitarbeiter \n" +
        TO_STRING_UHRZEIT               + ": to String fur uhrzeit \n" +
        ENDE                            + ": Programm beenden; \n Auswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case RAUM_ANLEGEN:
                raum = raumAnlegen();
                break;
            case MITARBEITER_ANLEGEN:
                mitarbeiter = mitarbeiterAnlegen();
                break;
            case UHRZEIT_ANLEGEN:
                uhrzeit = uhrzeitAnlegen();
                break;
            case RESERVIERUNG_ANLEGEN:
                reservierung = reservierungAnlegen();
                break;
            case TO_STRING_RAUM:
                System.out.println(raum.toString());
                break;
            case TO_STRING_RESERVIERUNG:
                System.out.println(reservierung.toString());
                break;
            case TO_STRING_MITARBEITER:
                System.out.println(mitarbeiter.toString());
                break;
            case TO_STRING_UHRZEIT:
                System.out.println(uhrzeit.toString());
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }

    /**
    *
    * @return neues Raum-Objekt
    */
    private Raum raumAnlegen() {
        int geb;
        int etage;
        int raum;

        System.out.println("Gebaudenumer: ");
        geb = input.nextInt();
        System.out.println("Etagenumer: ");
        etage = input.nextInt();
        System.out.println("Raumnumer: ");
        raum = input.nextInt();
        return new Raum(geb, etage, raum);
    }
    
    /**
    * 
    * @return neues Mitarbeiter-Objekt
    */
    private Mitarbeiter mitarbeiterAnlegen(){
        String vorname;
        String nachname;
        String email;

        System.out.println("Mitarbeiter vorname: ");
        input.nextLine();
        vorname = input.nextLine();
        System.out.println("Mitarbeiter nachname: ");
        nachname = input.nextLine();
        System.out.println("Mitarbeiter email: ");
        email = input.nextLine();
        return new Mitarbeiter(vorname, nachname, email);
    }
    
    /**
     * @return neues Uhrzeit-Objekt
     */
    private Uhrzeit uhrzeitAnlegen() {
        int stunde;
        int minute;

        System.out.print("Stunde: ");
        stunde = input.nextInt();
        System.out.print("Minute: ");
        minute = input.nextInt();
        return new Uhrzeit(stunde, minute);
    }
    
    /**
     * @return neues Reservierung-Objekt 
     */
    private Reservierung reservierungAnlegen(){
        Uhrzeit beginn;
        Uhrzeit ende;
        String bemerkung;
        
        System.out.print("Beginn: ");
        beginn = uhrzeitAnlegen();
        System.out.print("Ende: ");
        ende = uhrzeitAnlegen();
        System.out.println("Bemerkung: ");
        input.nextLine();
        bemerkung = input.nextLine();
        System.out.print("Raum: ");
        raum = raumAnlegen();
        mitarbeiter = mitarbeiterAnlegen();
        mitarbeiter.reserviere(raum, beginn, ende, bemerkung);
        return new Reservierung(beginn, ende);
    } 
    
    /**
     * Main-Methode zum Erzeugen des reservierungDialog-Objekts 
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new ReservierungDialog().start();
    }

}

____________________________________________________________________________________----
    
// second version of dialogue program
    import java.util.*;
/**
* Interaktive Testklasse fuer die Klasse Reservierung
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class ReservierungDialog
{
    //Attribute
    private Uhrzeit uhrzeit;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    private Reservierung reservierung;
    private Scanner input = new Scanner(System.in);

    
    //Klassenkonstanten
    
    //Konstanten fuer das Auswahl-Menue
    private static final int RAUM_ANLEGEN = 1;
    private static final int MITARBEITER_ANLEGEN = 2;
    private static final int UHRZEIT_ANLEGEN = 3;
    private static final int RESERVIERUNG_ANLEGEN = 4;
    private static final int ENDE = 0;
    
    //Konstanten fuer die Darstellung
    private static final String TRENNLINIE = 
        "-----------------------------------------------------------------------------------------";

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN IN IHRER RESERVIERUNG!");
        int auswahl = -1;

        while (auswahl != ENDE) {
            try {
                auswahl = einlesenAuswahl();
                ausfuehrenAuswahl(auswahl);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                input.nextLine();       //Absorption des "falschen" Tokens
            } catch (Exception e) {
                System.out.println("Achtung, gefangen Ausnahem: " + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
    * einlesenAuswahl Methode
    * Menue ausgeben und Auswahl einlesen
    *
    * @return eingelesene Auswahl als ganzzahliger Wert
    */
    private int einlesenAuswahl() {
        int auswahl;
        System.out.print(
        RAUM_ANLEGEN                    + ": Raum neu anlegen; \n" +
        MITARBEITER_ANLEGEN             + ": Mitarbeiter neu anlegen; \n" + 
        UHRZEIT_ANLEGEN                 + ": Uhrzeit neu anlegen  \n" +
        RESERVIERUNG_ANLEGEN            + ": Reservierung neu anlegen \n" +
        ENDE                            + ": Programm beenden; \n Auswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case RAUM_ANLEGEN:
                System.out.println(raumAnlegen());
                break;
            case MITARBEITER_ANLEGEN:
                System.out.println(mitarbeiterAnlegen());
                break;
            case UHRZEIT_ANLEGEN:
                System.out.println(uhrzeitAnlegen());
                break;
            case RESERVIERUNG_ANLEGEN:
                System.out.println("Dieser Raum wird reserviert..");
                raum = raumAnlegen();
                System.out.println("Dieser Mitarbeiter reserviert..");
                mitarbeiter = mitarbeiterAnlegen();
                System.out.println(reservierungAnlegen());
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }

    /**
    *
    * @return neues Raum-Objekt
    */
    private Raum raumAnlegen() {
        int geb;
        int etage;
        int raum;

        System.out.print("Gebaeudenummer: ");
        geb = input.nextInt();
        System.out.print("Etagenummer: ");
        etage = input.nextInt();
        System.out.print("Raumnummer: ");
        raum = input.nextInt();
        return new Raum(geb, etage, raum);
    }
    
    /**
    * 
    * @return neues Mitarbeiter-Objekt
    */
    private Mitarbeiter mitarbeiterAnlegen(){
        String vorname;
        String nachname;
        String email;

        input.nextLine();
        System.out.print("Mitarbeiter vorname: ");
        vorname = input.nextLine();
        System.out.print("Mitarbeiter nachname: ");
        nachname = input.nextLine();
        System.out.print("Mitarbeiter email: ");
        email = input.nextLine();
        return new Mitarbeiter(vorname, nachname, email);
    }
    
    /**
     * @return neues Uhrzeit-Objekt
     */
    private Uhrzeit uhrzeitAnlegen() {
        int stunde;
        int minute;

        System.out.print("Stunde: ");
        stunde = input.nextInt();
        System.out.print("Minute: ");
        minute = input.nextInt();
        return new Uhrzeit(stunde, minute);
    }
    
    /**
     * reservierungAnlegen testet, ob eine neu angelegte Reservierung 
     * zu einem Raum hinzugefuegt wird
     */
    private Raum reservierungAnlegen(){
        Uhrzeit beginn;
        Uhrzeit ende;
        String bemerkung;
        
        System.out.print("Beginn: ");
        beginn = uhrzeitAnlegen();
        System.out.print("Ende: ");
        ende = uhrzeitAnlegen();
        System.out.print("Bemerkung: ");
        input.nextLine();
        bemerkung = input.nextLine();
        mitarbeiter.reserviere(raum, beginn, ende, bemerkung);
        return raum;
    } 
    
    /**
     * Main-Methode zum Erzeugen des reservierungDialog-Objekts 
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new ReservierungDialog().start();
    }

}
