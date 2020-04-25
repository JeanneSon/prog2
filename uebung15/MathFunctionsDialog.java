import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Klasse MathFunctionsDialog zum interaktiven Testen der MathFunctions-Klasse
 * 
 * @author A. Venet und H. Schall 
 * @version 1.0
 */
public class MathFunctionsDialog
{
    //Attribute
    private MathFunctions mathFunctions = new MathFunctions();
    private Palindrom palindromRekursiv = new PalindromRekursiv();
    private Palindrom palindromIterativ = new PalindromIterativ();
    private Scanner input = new Scanner(System.in);

    //Klassenkonstanten
    private static final int TEILERSUMME = 1;
    private static final int PRUEFZIFFER = 2;
    private static final int NULLSTELLEN = 3;
    private static final int POTENZSUMME = 4;
    private static final int REIHENSUMME = 5;
    private static final int GGT = 6;
    private static final int PALINDROME_TEXT = 7;
    private static final int PALINDROME_DATEI = 8;
    private static final int ENDE = 0;

    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println("HERZLICH WILLKOMMEN IN MATH-FUNCTIONS!");
        System.out.println("Bitte wählen Sie aus.");

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
        TEILERSUMME         + ": Teilersumme zu einer übergebenen natürlichen Zahl berechnen und zurückgeben \n" + 
        PRUEFZIFFER          + ": Prüfziffer für eine ISBN-10 berechnen  \n" +
        NULLSTELLEN          + ": Nullstellen einer quadratischen Gleichung der Parameter p und q bestimmen \n" + 
        POTENZSUMME            + ": Summanden (a, b, c) von n, sodass a^4 + b^3 + c^2 \n" +
        REIHENSUMME         + " : Reihensumme von i=1 bis i=n, Formel  ∑ (x-1)ⁱ / (ixⁱ) \n" +
        GGT                 + " : groesster gemeinsamer Teiler mit Euklid \n" + 
        PALINDROME_TEXT + " : Palindrome uberpruefen von einem gegebene Text  \n" +
        PALINDROME_DATEI + " : Palindrome uberprufen von ein datei \n" +
        ENDE            + ": Programm beenden; \nAuswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    /**
     * ausfuehrenAuswahl verwaltet die verschiedenen Funktion je nach Auswahl
     *
     * @param auswahl
     */
    private void ausfuehrenAuswahl(int auswahl) {
        switch (auswahl) {
            case TEILERSUMME:
                System.out.println(mathFunctions.berechneTeilersumme(einleseLong("Bitte Zahl eingeben")));
                break;
            case PRUEFZIFFER:
                System.out.println(mathFunctions.berechneChecksummeIsbn(einleseLong("Bitte ISBN eingeben")));
                break;
            case NULLSTELLEN:
                System.out.println(mathFunctions.berechneNullstellen(
                          einleseDouble("Bitte p eingeben"), einleseDouble("Bitte q eingeben")
                ));
                break;
            case POTENZSUMME:
                long n = einleseLong("Bitte Zahl eingeben");
                System.out.println("Ist " + n + " als Summe von Potenzen darstellbar? (mit a^4 + b^3 + c^2)");
                System.out.println(mathFunctions.istSummeVonPotenzen(n));
                break;
            case REIHENSUMME:
                int n1 = einleseInt("Bitte n eingeben (positive ganze Zahl)");
                double x = einleseDouble("Bitte x eingeben");
                System.out.println(mathFunctions.berechneReihensumme(n1, x));
                break;
            case GGT:
                long a = einleseLong("Bitte natuerliche Zahl a eingeben");
                long b = einleseLong("Bitte natuerliche Zahl b eingeben");
                System.out.println(mathFunctions.berechneGgt(a, b));
                break;
            case PALINDROME_TEXT:
                String text = einleseText("Bitte ein Wort oder ein Text eingeben");
                System.out.println(palindromRekursiv.istPalindrom(text));
                System.out.println(palindromIterativ.istPalindrom(text));
                break;
            case PALINDROME_DATEI:
                String datei = einleseDatei("Bitte ein datei eingeben");
                System.out.println(palindromRekursiv.istPalindrom(text));
                System.out.println(palindromIterativ.istPalindrom(datei));
                break;
            case ENDE:
                System.out.println("Programmende");
                break;
            default:
                System.out.println("Falsche Auswahl!");
        }
    }

    /**
     * einleseLong liest eine Long-Zahl ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Long-Zahl
     */
    private long einleseLong(String msg) {
        System.out.print(msg + " (Typ Long) : \t");
        return input.nextLong();
    }

    /**
     * einleseDouble liest eine Double-Zahl ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Double-Zahl
     */
    private double einleseDouble(String msg) {
        System.out.print(msg + " (Typ Double): \t");
        return input.nextDouble();
    }

    /**
     * einleseInt liest eine Int-Zahl ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Int-Zahl
     */
    private int einleseInt(String msg) {
        System.out.print(msg + " (Typ Int) : \t");
        return input.nextInt();
    }
    
    /**
     * einleseText liest eine String-text ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene String-text
     */
    private String einleseText(String msg) {
        System.out.print(msg + " (Typ String) : \t");
        String test = input.nextLine();
        String wort = test.toLowerCase();
        String allowedList = "abcdefghijklmnopqrstuvwxyz";
        String temp = "";
        for (int i = 0; i < wort.length(); i++) {
            char c = wort.charAt(i);
            if (allowedList.indexOf(c) != -1) {
                temp += c;
            }
        }
        wort = temp;
        return wort;
    }
    /**
     * einleseDatei liest eine Datei ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Datei
     */
    private String einleseDatei(String msg) {
        
    }
    /**
     * Main-Methode zum Erzugen des MathFunctionsDialog-Objekts
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new MathFunctionsDialog().start();
    }
}
