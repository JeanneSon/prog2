public class Divide implements CrunchOperation 
{
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
        for (int i = 0, j =
    }
    
    
    /**
     * Sortiert ein int-Array nach dem InsertionSort-Algorithmus
     *
     * @param tab zu sortierendes Int-Array
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
                if (Math.abs(tab[j-1]) < EPSILON || Math.abs(temp) < EPSILON)
                    return []; //or throw exception
            }
            tab[j] = temp;
            ind[j] = temp2;
        }
        return tab;
    }
