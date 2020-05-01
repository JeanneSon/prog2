import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.IOException;
/**
 * Klasse PalindromDialog zum interaktiven Testen der MathFunctions-Klasse
 * 
 * @author A. Venet und H. Schall 
 * @version 1.0
 */
public class PalindromDialog
{
    //Attribute
    private Palindrom palindromRekursiv = new PalindromRekursiv();
    private Palindrom palindromIterativ = new PalindromIterativ();
    private Scanner input = new Scanner(System.in);

    //Klassenkonstanten
    private static final int PALINDROME_TEXT = 1;
    private static final int PALINDROME_DATEI = 2;
    private static final int ENDE = 0;
    
    //Konstanten fuer das Unter-Menue
    private static final int REKURSIV = 1;
    private static final int ITERATIV = 2;
    private static final String SEPARATOR = "------------------------------------------------------------------------";
    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println(SEPARATOR);
        System.out.println("HERZLICH WILLKOMMEN IN PALINDROME!");
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
        System.out.println(SEPARATOR);
        System.out.print(
        PALINDROME_TEXT + " : Palindrome uberpruefen von einem gegebene Text  \n" +
        PALINDROME_DATEI + " : Palindrome uberprufen von ein datei \n" +
        ENDE            + " : Programm beenden; \nAuswahl:\t");

        auswahl = input.nextInt();
        input.nextLine();
        return auswahl;
    }

    /**
     * ausfuehrenAuswahl verwaltet die verschiedenen Funktion je nach Auswahl
     *
     * @param auswahl
     */
    private void ausfuehrenAuswahl(int auswahl) throws IOException, IllegalArgumentException {
        switch (auswahl) {
            case PALINDROME_TEXT:
                String text = einleseText("Bitte ein Wort oder ein Text eingeben");
                text = processString(text);
                wahlEinMethode(text);
                break;
            case PALINDROME_DATEI:
                String datei = einleseDatei("Bitte ein datei eingeben");
                datei = processString(datei);
                wahlEinMethode(datei);
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
     */
    private void wahlEinMethode(String text) {
        int methode =    einlesenInt("Methode? (1 = rekursiv; 2 = iterativ) ");
        //Aufsaugen der letzten Zeile
        input.nextLine();
        if (methode == REKURSIV) {
            System.out.println(palindromRekursiv.istPalindrom(text));
        } else if (methode == ITERATIV) {
            System.out.println(palindromIterativ.istPalindrom(text));
        }
        else {
            System.out.println("Falsche Methode eingegeben");
        }
    }
    
    private int einlesenInt(String eingabeaufforderung) {
        int zahl;
        System.out.print(eingabeaufforderung);
        zahl = input.nextInt();
        return zahl;
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
        return test;
    }
    
    /**
     * processString 
     * 
     * @param wort 
     * @return eingelesene String-text nur mit buchstaben von 'a' bis 'z'
     */
    public String processString(String wort) throws IllegalArgumentException
    {
        wort = wort.toLowerCase().trim();
        String allowedList = "abcdefghijklmnopqrstuvwxyz0123456789";
        String temp = "";
        for (int i = 0; i < wort.length(); i++) {
            char c = wort.charAt(i);
            if (allowedList.indexOf(c) != -1) {
                temp += c;
            }
        }
        if (temp.isEmpty())
            throw IllegalArgumentException("Leerer String");
        return temp;
    }

    /**
     * einleseDatei liest eine Datei ein
     *
     * @param msg ist die Eingabeaufforderung
     * @return eingelesene Datei
     */
    private String einleseDatei(String msg) throws IOException{
        System.out.print(msg + " (Typ String) : \t");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        Path p3 = Paths.get(filePath);
        String content = Files.readString(p3, StandardCharsets.US_ASCII);
        String replaceString = content.replace("\n", "").replace("\r", "");
        return replaceString;
    }
    /**
     * Main-Methode zum Erzugen des PalindromDialog-Objekts
     * und zum Anstarten der Testschleife
     */
    public static void main(String[] args) {
        new PalindromDialog().start();
    }
}
