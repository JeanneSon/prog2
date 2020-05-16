public class Divide implements CrunchOperation 
{
    /**
     * Konstruktor ist private, damit keine Objekte dieser Klasse angelegt werden koennen
     */
    private Divide ();
    
    
    /**
     *  Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und 
     *  speichert den neuen Wert im Datenfeld des jeweils größeren Wertes. 
     *  D.h. der größte Wert wird durch den Kleinsten geteilt. 
     *  Der Zweitgrößte durch den Zweitkleinsten usw. 
     *
     *  @param values uebergebendes Array, das veraendert wird (s.o.)
     */
    public static void crunch(float values[])
    {
        int[] indexes = new int[];
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
        int l = tab.length; 
        int temp, j;
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
     */
    public static String toString() {
        return "Teilt die n/2 groessten Werte im Array durch die n/2 Kleinsten und"
                + "speichert den neuen Wert im Datenfeld des jeweils groesseren Wertes."
                + "D.h. der größte Wert wird durch den Kleinsten geteilt." 
                + "Der Zweitgroesste durch den Zweitkleinsten usw.";
    }
