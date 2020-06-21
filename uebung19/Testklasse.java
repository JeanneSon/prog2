import java.util.*;

/**
* Interaktive Testklasse fuer die Klasse Artikel
* 
* @author A. Venet und H. Schall
* @version 1.0
*/
public class Testklasse
{
    //Attribute
    private Scanner input = new Scanner(System.in);
    
    //Klassenkonstanten
    private static final int ENDE = 0;

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
        ENDE            + ": Programm beenden; \nAuswahl:\t");
        
        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }
    
    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
        System.out.println();
    }

    /**
     * Main-Methode zum Erzeugen des ArtikelDialog-Objekts und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new Testklasse().start();
    }
    
}
