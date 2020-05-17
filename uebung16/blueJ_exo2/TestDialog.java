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
    
    private Sum sum = new Sum();
    private Subtract subtract = new Subtract();
    private Swirl swirl = new Swirl();
    private Divide divide = new Divide();
    private Average average = new Average();
    
    //Klassenkonstanten
    private static final int SUM = 1;
    private static final int SWIRL = 2;
    private static final int DIVIDE = 3;
    private static final int SUBTRACT = 4;
    private static final int AVERAGE = 5;
    private static final int ENDE = 0;
    private static final char ZUFALIGES_ARRAY = 'z';
    private static final char EINGEGEBENE_ARRAY ='e';
    //Untermenu
    private static final int NUMBER_CRUNCHER_ANONYM = 1;
    private static final int NUMBER_CRUNCHER_TOPLEVEL = 2;

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN!");
        System.out.print( "Möchten Sie auf eigenen Float-Array operieren"
        + "oder soll ein zufälliges erzeugt werden? \n");
        char arrayTyp = typArrayAuswahlen();
        float[] values = ausfuehrenArrayAuswahl(arrayTyp);
        int auswahl = -1;

        while (auswahl != ENDE) {
            try {
                auswahl = einlesenAuswahl();
                ausfuehrenAuswahl(auswahl, values);
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
        char auswahl;
        System.out.print(
        ZUFALIGES_ARRAY + " :zufalliges array erzeugen \n" +
        EINGEGEBENE_ARRAY + " :array eingeben \n");
        auswahl = input.next().charAt(0);
        input.nextLine();
        return auswahl;
     }

    private float[] ausfuehrenArrayAuswahl(char auswahl) {
        float[] array = new float[10];
        switch (auswahl) {
            case ZUFALIGES_ARRAY:
                float[] zufaligesArray = randomArray();
                break;
            case EINGEGEBENE_ARRAY:
                float[] eingegebeneArray = einleseArray();
                return eingegebeneArray;
            default:
                System.out.println("Falsche Auswahl!");
        }
        return array;
    }

    /**
    * Methode zum Anlegen eines Zufaelliges Array
    *
    * @return ein Float-Array
    */
    private float[] randomArray(){
        
        return new float[10];
    }
    
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
    private void ausfuehrenAuswahl(int auswahl, float[] values) {
        switch (auswahl) {
            case SUM:
                wahlEinMethode(values);
                
                break;
            case SWIRL:
                wahlEinMethode(values);
                
                break;
            case DIVIDE:
                wahlEinMethode(values);
                
                break;
            case SUBTRACT:
                wahlEinMethode(values);
                
                break;
            case AVERAGE:
                wahlEinMethode(values);
                
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }
    /**
     * wahlEinMethode
     * 
     * @param text ein String
     */
    private void wahlEinMethode(float[] values) {
        int methode =    einlesenInt("Methode? (1 = anonymKlasse; 2 = topLevelKlasse) ");
        //Aufsaugen der letzten Zeile
        input.nextLine();
        if (methode == NUMBER_CRUNCHER_ANONYM) {
            System.out.println();
        } else if (methode == NUMBER_CRUNCHER_TOPLEVEL) {
            System.out.println();
        }
        else {
            System.out.println("Falsche Methode eingegeben");
        }
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
     * Main-Methode zum Erzeugen des lagerDialog-Objekts 
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new TestDialog().start();
    }

}
