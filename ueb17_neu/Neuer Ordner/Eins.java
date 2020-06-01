import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.function.IntPredicate;

/**
 * TestDialog Klasse fuer ueb 17 
 * 
 * @author VENET Aurianne & SCHALL Hanna
 * @version 1.0
 */
public class Eins
{
    //Klassenkonstanten
    private static final String WELCOME = 
        "Herzlich Willkommen zu Uebung 17!\n" +
        "Sie koennen hier die Aufgabenteile 1a und 1b ausprobieren.\n";
    private static final String FKT_AUSWAEHLEN =
        "Bitte waehlen Sie aus, welche Funktion Sie ausprobieren moechten:\n" +
        "1)  f(x) = x^2\n" +
        "2)  f(x) = x!\n" +
        "3)  f(x) = x^(x+1)\n" +
        "4)  f(x) = fib(x)\n" +
        "   --> Waehlen Sie jetzt und geben sie 1, 2, 3 oder 4 ein.";
    private static final String I_J_AUSWAEHLEN =
        "Die von Ihnen ausgewaehlte Funktion wird nun auf alle x {x|i < x < j} angewandt.\n";
    private static final String I_EINLESEN =
        "Bitte geben Sie jetzt i ein. i muss eine natuerliche Zahl (int >0) sein.";
    private static final String J_EINLESEN =
        "Bitte geben Sie jetzt j ein. j muss eine natuerliche Zahl (int >0 und >j) sein.";
    private static final int QUADRAT = 1;
    private static final int FAKULTAET = 2;
    private static final int EXPONENT = 3;
    private static final int FIBONACCI = 4;
    
    //Attribute
    private Scanner input;
    
    public Eins () {
        input = new Scanner(System.in);
    }
    
    /**
     * applyAndPrint Methode
     *
     * @param i ein uebergebenen Integer
     * @param j ein uebergebenen Integer
     * @param f (typ MyFunction) wird auf die Zahlen angewendet
     * @return ein liste von number zwischen i und j die 
     */
    public void applyAndPrint(int i, int j, MyFunction f) throws IllegalArgumentException
    {
        List<Integer> result = new ArrayList<>();
        for(int x = i+1; x<j; x++){
            result.add(f.apply(x));
        }
        System.out.println(result);
    }
    
    
    public static void main(String[] args) {
        new Eins().start();
    }
    
    /**
    *Hauptschleife des Testprogramms
    */
    public void start() {
        System.out.println(WELCOME);
        int fkt = inputInt(FKT_AUSWAEHLEN);
        System.out.println(I_J_AUSWAEHLEN);
        int i = inputInt(I_EINLESEN);
        int j = inputInt(J_EINLESEN);
        if (i < 1 || j < 1)
            throw new IllegalArgumentException("i und j muessen natuerliche Zahlen sein.");
        if (i >= j)
            throw new IllegalArgumentException("i und j bilden kein gueltiges Intervall.");
        executeLambda(i, j, fkt);
        executeACl(i, j, fkt);
        executeFakultaetTopLevel(i, j);
        executeFakultaetStaticNestedCl(i, j);
    }
    //Klassenkonstanten
    private static final MyFunction QUADRAT_LAMBDA = n -> n*n;
    private static final MyFunction FAKULTAET_LAMBDA = 
        n -> n <= 0 ? 1 : n * Eins.FAKULTAET_LAMBDA.apply(n - 1);
    private static final MyFunction EXPONENT_LAMBDA = n -> (int) Math.pow(n, n+1);
    private static final MyFunction FIBONACCI_LAMBDA = 
          n -> (n == 0 || n == 1)
             ? n : Eins.FIBONACCI_LAMBDA.apply(n-1) + Eins.FIBONACCI_LAMBDA.apply(n-2);
    
     //Anonyme function
    private static final MyFunction QUADRAT_A_CL = new MyFunction() {
        public int apply(int i) {
            return i*i;
        }
    };
    
    private static final MyFunction FAKULTAET_A_CL = new MyFunction() {
        public int apply(int i) {
            if (i >= 0)
                return 1;
            else
                return i * apply(i-1);
        }
    };
    
    private static final MyFunction EXPONENT_A_CL = new MyFunction() {
        public int apply(int i) {
            return (int) Math.pow(i, i+1);
        }
    };
    
    private static final MyFunction FIBONACCI_A_CL = new MyFunction() {
        public int apply(int i) {
            if (i == 0 || i == 1)
                return i;
            else
                return apply(i-1) + apply(i-2);
        }
    };
    
    /**
     * executeLambda Methode
     *      methode die die Lambda Ausdruck als funktion benutzt
     * @param i ein Integer
     * @param j ein Integer
     * @param fkt funktion die auf die Zahlen angewendet wird
     */
    private void executeLambda(int i, int j, int fkt) {
        System.out.println("Ergebnisliste, Berechnung mit Lambda-Ausdruecken:");
        switch (fkt) {
            case QUADRAT:
                applyAndPrint(i, j, QUADRAT_LAMBDA);
                break;
            case FAKULTAET:
                applyAndPrint(i, j, FAKULTAET_LAMBDA);
                break;
            case EXPONENT:
                applyAndPrint(i, j, EXPONENT_LAMBDA);
                break;
            case FIBONACCI:
                applyAndPrint(i, j, FIBONACCI_LAMBDA);
                break;
            default:
                System.out.println("Eingabe nicht korrekt, Funktion nicht gefunden.");
        }
    }
    
    /**
     * executeACl Methode
     *      methode die die AnonymenKlasse als funktion benutzt
     * @param i ein Integer
     * @param j ein Integer
     * @param fkt funktion die auf die Zahlen angewendet wird
     */
    private void executeACl(int i, int j, int fkt) {
        System.out.println("Ergebnisliste, Berechnung mit Anonymen Klassen:");
        switch (fkt) {
            case QUADRAT:
                applyAndPrint(i, j, QUADRAT_A_CL);
                break;
            case FAKULTAET:
                applyAndPrint(i, j, FAKULTAET_A_CL);
                break;
            case EXPONENT:
                applyAndPrint(i, j, EXPONENT_A_CL);
                break;
            case FIBONACCI:
                applyAndPrint(i, j, FIBONACCI_A_CL);
                break;
            default:
                System.out.println("Eingabe nicht korrekt, Funktion nicht gefunden.");
        }
    }
    
    /**
     * executeFakultaetTopLevel Methode
     *
     * @param i ein Integer
     * @param j ein Integer
     */
    private void executeFakultaetTopLevel(int i, int j) {
        System.out.println(
            "Nun die Ergebnisliste von der Berechnung f(x)=x! mit TopLevelKlasse-Implementierung"
        );
        FakultaetTopLevel fakultaetTopLevel = new FakultaetTopLevel();
        List<Integer> result = new ArrayList<>();
        for(int x = i+1; x<j; x++){
            result.add(fakultaetTopLevel.fakultaet(x));
        }
        System.out.println(result); 
    }
    
    /**
     * FakultaetStaticNestedCl
     *      NestedKlasse fuer Fakultaet
     */
    private static class FakultaetStaticNestedCl {
        /**
         * fakultaet Methode
         *
         * @param n gegebene Integer
         * @return fakultaet von n (n!)
         */
        public int fakultaet(int n)
        {
            if (n <= 0)
                return 1;
            else
                return n * fakultaet(n-1);
        }
    }
    
    private void executeFakultaetStaticNestedCl(int i, int j) {
        System.out.println(
            "Nun die Ergebnisliste von der Berechnung f(x)=x! mit StaticNestedClass-Implementierung"
        );
        Eins.FakultaetStaticNestedCl fakultaetStaticNestedCl = new Eins.FakultaetStaticNestedCl();
        List<Integer> result = new ArrayList<>();
        for(int x = i+1; x<j; x++){
            result.add(fakultaetStaticNestedCl.fakultaet(x));
        }
        System.out.println(result); 
    }
    
    private int inputInt(String msg) {
        System.out.println(msg);
        return input.nextInt();
    }
    
    
    IntPredicate even = i -> i % 2 == 0;
    
    IntPredicate odd = new IntPredicate() {
        public boolean test(int n) {        
            return n % 2 != 0;    
        }
    };
    
    private void executeE(int i, int j) {
        ExtendedInterface eI = n -> n*n;
        applyAndPrint(i, j, eI.conditionateInput(even));
    }
    
    private void execute(int i, int j) {
        ExtendedInterface eI = n -> n*n;
        applyAndPrint(i, j, eI.conditionateInput(even));
    }
    
    
    //source for lambda-recursion:
    // https://community.oracle.com/thread/3965169?start=0&tstart=0
}
