public class Divide implements CrunchOperation 
{
    public static void crunch(float values[]);
    
    
    /**
     * Sortiert ein int-Array nach dem InsertionSort-Algorithmus
     *
     * @param tab zu sortierendes Int-Array
     * @return sortiertes Int-Array
     */
    public static float[] insertionSort(float tab[])
    {
        int l = tab.length; 
        int temp, j;
        for (int i = 1; i < l; i++) {
            temp = tab[i];
            j = i;
            while (j > 0 && tab[j-1] > temp) {
                tab[j] = tab[j-1];
                j--;
            }
            tab[j] = temp;
        }
        return tab;
    }
