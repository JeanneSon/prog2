/**
 * Swirl
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class Divide implements CrunchOperation 
{
    //Klassenkonstanten
    public static final float EPSILON = 10e-6F;
    // Fehlermeldungen
    private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";
    
    /**
     *  Teilt die n/2 groessten Werte im Array durch die n/2 Kleinsten und 
     *  speichert den neuen Wert im Datenfeld des jeweils groesseren Wertes. 
     *  D.h. der größte Wert wird durch den Kleinsten geteilt. 
     *  Der Zweitgroesste durch den Zweitkleinsten usw. 
     *
     *  @param values uebergebendes Array, das veraendert wird (s.o.)
     */
    public void crunch(float values[])
    {
        check(values.length != 0, MSG_ARRAY_LEER); 
        int[] indexes = new int[values.length];
        for (int i = 1; i < values.length; i++) {
            indexes[i] = i;
        }
        float[] sortedValues = new float[values.length];
        System.arraycopy(values, 0, sortedValues, 0, 3);
        sortedValues = insertionSort(sortedValues, indexes);
        //here comes for-loop which does the work
        for (int i = 0, j = values.length-1; i < values.length / 2; i++, j--) {
            if (Math.abs(sortedValues[i]) < EPSILON)
                continue;
            values[j] = sortedValues[j] / sortedValues[i];
        }
    }
    
    
    /**
     * Sortiert ein int-Array nach dem InsertionSort-Algorithmus
     *
     * @param tab zu sortierendes Int-Array
     * @param ind mit zu sortierendem Array, das die Originalreihenfolge speichert
     * @return sortiertes Int-Array
     */
    public static float[] insertionSort(float tab[], int ind[])
    {
        int l = tab.length, j, temp2; 
        float temp;
        for (int i = 1; i < l; i++) {
            temp = tab[i];
            temp2 = ind[i];
            j = i;
            while (j > 0 && tab[j-1] > temp) {
                tab[j] = tab[j-1];
                ind[j] = ind[j-1];
                j--;
            }
            tab[j] = temp;
            ind[j] = temp2;
        }
        return tab;
    }

    /**
     * Informiert ueber die Aufgabe der Klasse
     * @return String
     */
    @Override
    public String toString() {
        return "Teilt die n/2 groessten Werte im Array durch die n/2 Kleinsten und"
                + "speichert den neuen Wert im Datenfeld des jeweils groesseren Wertes."
                + "D.h. der größte Wert wird durch den Kleinsten geteilt." 
                + "Der Zweitgroesste durch den Zweitkleinsten usw.";
    }
    
    /**
    * check
    * 
    * @param bedingung, die erfuellt werden soll
    * @param msg Fehlermeldung, die ausgeben wird falls Bedingung nicht erfuellt
    */
    private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}