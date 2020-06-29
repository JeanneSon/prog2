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
    private Scanner input ;
    private Coordinator coordinator;
    private Consumer c;
    private Producer p;
    

    //Klassenkonstanten
    private static final int ENDE = 0;
    private static final int ZUFAELIGE_INTEGER = 1;
    private static final int QUERSUMME = 2;
    private static final int NUMBER_DIFFERENCE = 3;
    private static final int NUMBER_OCCURENCE = 4;
    private static final int ASCENDING= 5;
    private static final int DESCENDING = 6;
    private static final int TIMESTAMP = 7;
    
    public Testklasse() {
        input = new Scanner(System.in);
        coordinator = new Coordinator();
        p = new Producer();
        c = new Consumer();
    }

    /**
    *Hauptschleife des Testprogramms
    */
    public void start()  throws IllegalArgumentException{
        System.out.println("HERZLICH WILLKOMMEN");
        System.out.println("Es wird nun jeweils die Quersumme von verschiedenen zufaelligen Integern (zwischen 0 und 100) berechnet.");
        int variante = einlesenInt("Welche Variante? \n\tnatuerliche Ordnung -> 1 \n\tFIFO -> 2\n");
        if (variante == 1)
            coordinator.start("natuerlich");
        else if (variante == 2)
            coordinator.start("FIFO");
        else
            throw new IllegalArgumentException("argument not valid; put either \"FIFO\" or \"natuerlich\"");
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

        ZUFAELIGE_INTEGER        + ": Generieurng ein zufalliges integer zwischen 0 und 1000 und dessen Quersumme berechnen\n"+
        "-----------------betrifft nun die automatisch zufaellig generierte Integers-----------------\n" +
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
                int z = p.produce();
                System.out.println("Ihr Integer: " + z);
                c.consume(z);
                System.out.println("Im Consumer ist nun gespeichert: " + c.getCrossTotalsAscending()) ;
                break;
            case NUMBER_DIFFERENCE:
                System.out.println(coordinator.c.numberOfDifferentResults());
                break;
            case NUMBER_OCCURENCE:
                int v = einlesenInt("Fuer welche Quersumme? \n");
                System.out.println(coordinator.c.numberOfOccurrences(v));
                break;
            case ASCENDING:
                System.out.println(coordinator.c.getCrossTotalsAscending());
                break;
            case DESCENDING:
                System.out.println(coordinator.c.getCrossTotalsDescending());
                break;
            case TIMESTAMP:
                int w = einlesenInt("Fuer welche Quersumme? \n");
                System.out.println(coordinator.c.getTimestampsForResult(w));
                break;
            case ENDE:
                System.out.println("au revoir");
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