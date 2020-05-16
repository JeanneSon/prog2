import java.util.*;
/**
* Interaktive Testklasse fuer die Klasse Lager
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class TestDialog
{
    //Attribute
    private Scanner input = new Scanner(System.in);

    //Klassenkonstanten
    private static final int SUM = 1;
    private static final int SWIRL = 2;
    private static final int DIVIDE = 3;
    private static final int SUBTRACT = 4;
    private static final int AVERAGE = 5;
    private static final int ENDE = 0;
    private static final char ZUFALIGES_ARRAY = 'z';
    private static final char EINGEGEBENE_ARRAY ='e';    

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN!");
        System.out.print( "Möchten Sie auf eigenen Float-Array operieren"
        + "oder soll ein zufälliges erzeugt werden?");
        char arrayTyp = typArrayAuswahlen();
        float[] values = ausfuehrenArrayAuswahl(arrayTyp);
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
    * typArrayAuswahlen Methode
    * Menue ausgeben und Auswahl einlesen
    *
    * @return eingelesene Auswahl 
    */
    private char typArrayAuswahlen() {
        System.out.print( "Möchten Sie auf eigenen Float-Array operieren"
        + "oder soll ein zufälliges erzeugt werden?");
        char auswahl;
        System.out.print(
        ZUFALIGES_ARRAY + " zufalliges array erzeugen \n" +
        EINGEGEBENE_ARRAY + " :array eingeben \n");
        auswahl = input.next().charAt(0);
        input.nextLine();
        return auswahl;
     }

    private void ausfuehrenArrayAuswahl(char auswahl) {
        switch (auswahl) {
            case ZUFALIGES_ARRAY:
                //int[] zufaligesArray = randomArray();
                break;
            case EINGEGEBENE_ARRAY:
                float[] eigegebeneArray = einleseArray();
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }

    /**
    * Methode zum Anlegen eines Zufaelliges Array
    *
    * @return ein Float-Array
    */
    //private float[] randomArray(){
        
    //    return [];
    //}
    
    /**
     * liest eine Array ein
     * @return ein Float-Array 
     */
    private float[] einleseArray() {
        System.out.print("Array: ");
        System.out.print("Enter number of elements you want in array:");
        int length = input.nextInt();
        float array[] = new float[length];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < length; i++){
            array[i] = input.nextInt();
        }
        return array;
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
        SUM         + ": Summiert die Elemente des Arrays paarweise von links nach"
                    +"rechts D.h.: a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw. \n" +
        SWIRL       + ": Fuehrt n zufaellige Vertauschungen der Datenfelder durch "
                    +"n ist durch die Laenge desfloat-Arrays gegeben. \n" + 
        DIVIDE      + ": Teilt die n/2 groessten Werte im Array durch die n/2 Kleinsten \n" +
        SUBTRACT   + ": Analog zu sum nur mit Substraktion \n" +
        AVERAGE     + ": Bestimmt den Durchschnitt aller Werte im Array und " 
                    + "speichert sie mit dem groessten Wert.  \n" +
        ENDE        + ": Programm beenden; \n Auswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }
    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case SUM:
                float[] sumArray = einleseArray();
                
                break;
            case SWIRL:
                float[] swirlArray = einleseArray();
                
                break;
            case DIVIDE:
                float[] divideArray = einleseArray();
                
                break;
            case SUBTRACT:
                float[] substractArray = einleseArray();
                
                break;
            case AVERAGE:
                float[] averageArray = einleseArray();
                
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }
    /**
     * Main-Methode zum Erzeugen des lagerDialog-Objekts 
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new TestDialog().start();
    }

}
