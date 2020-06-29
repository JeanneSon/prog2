import java.util.*;

/**
* Interaktive Testklasse 
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class Testklasse 
{
    //Attribute
    private Scanner input = new Scanner(System.in);
    private Coordinator coordinator;
    

    //Klassenkonstanten
    private static final int ENDE = 0;
    private static final int ZUFAELIGE_INTEGER = 1;
    private static final int QUERSUMME = 2;
    private static final int NUMBER_DIFFERENCE = 3;
    private static final int NUMBER_OCCURENCE = 4;
    private static final int ASCENDING= 5;
    private static final int DESCENDING = 6;
    private static final int TIMESTAMP = 7;

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

        ZUFAELIGE_INTEGER        + ": Generieurng ein zufalliges integer zwischen 0 und 1000\n"+
        QUERSUMME            + ": Berechnung von die Quersumme ein zufalliges integer \n" +
        NUMBER_DIFFERENCE        + ": gibt an, wie viele unterschiedliche Quersummen berechnet wurden \n"+
        NUMBER_OCCURENCE        + ": gibt für einen gegebenen Integer an, wie häufig dieser als Ergebnis einer Berechnung vorkam\n"+
        ASCENDING            + ": gibt die berechneten Quersummen in aufsteigender Reihenfolge\n"+
        DESCENDING        + ": gibt die berechneten Quersumme in absteigender reihenfolge\n"+
        TIMESTAMP         + ": gibt die Zeitstempel einen Integer an\n"+
        ENDE            + ": Programm beenden; \nAuswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case ZUFAELIGE_INTEGER:
                
                break;
            case QUERSUMME:
                
                break;
            case NUMBER_DIFFERENCE:
                
                break;
            case NUMBER_OCCURENCE:
                
                break;
            case ASCENDING:
                
                break;
            case DESCENDING:
                
                break;
            case TIMESTAMP:
                
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