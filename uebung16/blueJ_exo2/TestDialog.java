import java.util.*;
import java.lang.StringBuilder;
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
        + "oder soll ein zufaelliges erzeugt werden? \n");
        char arrayTyp = typArrayAuswahlen();
        int laenge = einlesenInt("Welche Groesse soll das Array haben? Bitte Groesse > 0 eingeben");
        if (laenge <= 0) {
            System.out.println("Ungueltige Laenge. Ich waehle fuer Sie die Laenge 5.");
            laenge = 5;
        }
        float[] values = ausfuehrenArrayAuswahl(arrayTyp, laenge);        
        NumberCruncherAnonym ncal = new NumberCruncherAnonym(values);
        NumberCruncherTopLevel nctl = new NumberCruncherTopLevel(values);
        System.out.println("Hier ist es " + valuesToString(values));
        String operationen = einlesenAuswahl();
        int methode = wahlEinMethode();
        values = process(operationen, values, methode, ncal, nctl);
    }

    
    private float[] process(String operationen, float[] values, int methode, NumberCruncherAnonym ncal, NumberCruncherTopLevel nctl) {
        String[] operations = operationen.split(" ");
        if (methode == NUMBER_CRUNCHER_ANONYM)
            ncal.crunch(operations);
        else
            if (methode == NUMBER_CRUNCHER_TOPLEVEL)
                nctl.crunch(operations);
        return values;
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

    private float[] ausfuehrenArrayAuswahl(char auswahl, int laenge) throws InputMismatchException{
        switch (auswahl) {
            case ZUFALIGES_ARRAY:
                return randomArray(laenge);
            case EINGEGEBENE_ARRAY:
                return einleseArray(laenge);
            default:
                throw new InputMismatchException("Falsche Auswahl!");                
        }
    }

    /**
    * Methode zum Anlegen eines Zufaelliges Array
    *
    * @return ein Float-Array
    */
    private float[] randomArray(int laenge){
        float randArr[] = new float[laenge];
        Random rand = new Random();
        for (int i = 0; i < laenge; i++) {
            randArr[i] = rand.nextFloat();
        }
        return randArr;
    }
    
    /**
     * liest eine Array ein
     * @return ein Float-Array 
     */
    private float[] einleseArray(int length) {
        float array[] = new float[length];
        System.out.println("Geben Sie die Elemente ein:");
        for(int i = 0; i < length; i++){
            array[i] = input.nextFloat();
        }
        return array;
    }
    
    /**
    * einlesenAuswahl Methode
    * Menue ausgeben und Auswahl einlesen
    *
    * @return eingelesene Auswahl als ganzzahliger Wert
    */
    private String einlesenAuswahl() {
        int auswahl;
        System.out.print(
                    "sum (Summiert die Elemente des Arrays paarweise von links nach" +
                            "rechts D.h.: a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw.) \n" +
                    "swirl (Fuehrt n zufaellige Vertauschungen der Datenfelder durch " +
                            "n ist durch die Laenge desfloat-Arrays gegeben.) \n" + 
                    "divide (Teilt die n/2 groessten Werte im Array durch die n/2 Kleinsten) \n" +
                    "subtract (Analog zu sum nur mit Substraktion) \n" +
                    "average (Bestimmt den Durchschnitt aller Werte im Array und " +
                            "speichert sie mit dem groessten Wert.  \n\n" +
                    "Geben Sie jetzt alle Operationen ein, die nacheinander " + 
                            "ausgefuehrt werden sollen. Trennen Sie die Operationen mit einem Leerzeichen. : "
        );
        String operationen = input.nextLine();
        return operationen;
    }
    
    /**
     * wahlEinMethode
     * 
     * @param text ein String
     */
    private int wahlEinMethode()  throws InputMismatchException{
        int methode = einlesenInt("Methode? (1 = anonymKlasse; 2 = topLevelKlasse) ");
        //Aufsaugen der letzten Zeile
        input.nextLine();
        if (methode == NUMBER_CRUNCHER_ANONYM || methode == NUMBER_CRUNCHER_TOPLEVEL) {
            return methode;
        } 
        else {
            throw new InputMismatchException("Falsche Auswahl!");
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

    /**
     * valuesToString
     *
     * @param values Array
     * @return String
     */
    private String valuesToString(float[] values) {
        StringBuilder sb = new StringBuilder("[ ");
        for (float elem : values) {
            sb.append(elem + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}
