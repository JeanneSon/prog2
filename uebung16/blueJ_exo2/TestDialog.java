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

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN!");
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
                int[] sumArray = einleseArray();
                
                break;
            case SWIRL:
                int[] swirlArray = einleseArray();
                
                break;
            case DIVIDE:
                int[] divideArray = einleseArray();
                
                break;
            case SUBTRACT:
                int[] substractArray = einleseArray();
                
                break;
            case AVERAGE:
                int[] averageArray = einleseArray();
                
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }

    /**
     * liest eine Array ein
     * @return prozent 
     */
    private int[] einleseArray() {
        System.out.print("Array: ");
        System.out.print("Enter number of elements you want in array:");
        int length = input.nextInt();
        int array[] = new int[length];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < length; i++){
            array[i] = input.nextInt();
        }
        return array;
    }
    
    /**
     * Main-Methode zum Erzeugen des lagerDialog-Objekts 
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new TestDialog().start();
    }

}
