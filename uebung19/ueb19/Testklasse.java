import java.util.*;

/**
* Interaktive Testklasse fuer die Klasse DoppeltVerkettete
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class Testklasse 
{
    //Attribute
    private Scanner input = new Scanner(System.in);
    private DoppeltVerketteteListe dvl = new DoppeltVerketteteListe();

    //Klassenkonstanten
    private static final int ENDE = 0;
    private static final int SIZE = 1;
    private static final int CONTAINS = 2;
    private static final int IS_EMPTY = 3;
    private static final int TO_ARRAY = 4;
    private static final int ADD = 5;
    private static final int REMOVE_O = 6;
    private static final int ADD_ALL = 7;
    private static final int CLEAR = 8;
    private static final int GET = 9;
    private static final int SET = 10;
    private static final int ADD_INDEX = 11;
    private static final int REMOVE_INDEX = 12;
    private static final int INDEX_OF = 13;

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN");
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

        SIZE            + ": Gibt die Größe der Doppelt verketteteten Liste zurueck; \n" +
        IS_EMPTY        + ": Prueft ob DVL leer ist\n"+
        CONTAINS        + ": Prüft ob bestimmtes Object in DVL enthalten ist\n"+
        TO_ARRAY        + ": Wandelt DVL in Array um\n"+
        ADD             + ": Fügt Node am Ende der DVL an\n"+
        REMOVE_O        + ": Entfernt ein bestimmtes Objekt\n"+
        ADD_ALL         + ": Alles ans Ende der Liste anfügen\n"+
        CLEAR           + ": Loescht alles\n"+
        GET             + ": Bestimmten Wert ausgeben\n"+
        SET             + ": Auf bestimmten Wert setzen\n"+
        ADD_INDEX       + ": Node an bestimmter Stelle einfuegen\n"+
        REMOVE_INDEX    + ": Node an bestimmter Stelle loeschen\n"+
        INDEX_OF        + ": Index eines bestimmten Wertes ausgeben\n"+
        ENDE            + ": Programm beenden; \nAuswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case SIZE:
                System.out.println("Size: " + dvl.size());
                break;
            case IS_EMPTY:
                System.out.println("Empty? " + dvl.isEmpty());
                break;
            case CONTAINS:
                //System.out.println("Contains?" + dvl.contains());
                break;
            case TO_ARRAY:
                System.out.println(dvl.toArray());
                break;
            case ADD:
                add();
                break;
            case REMOVE_O:
                remove();
                break;
            case ADD_ALL:
                addAll();
                break;
            case CLEAR:
                clear();
                break;
            case GET:
                get();
                break;
            case SET:
                set();
                break;
            case ADD_INDEX:
                add();
                break;
            case REMOVE_INDEX:
                remove();
                break;
            case INDEX_OF:
                indexOf();
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
        System.out.println();
    }
    
    /**
     * einleseInt liest eine Integer ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Integer
     */
    private int einlesenInt(String msg) {
        int zahl;
        System.out.print(msg);
        zahl = input.nextInt();
        return zahl;
    }
    
    /**
     * Main-Methode zum Erzeugen des ArtikelDialog-Objekts und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new Testklasse().start();
    }
    
}
