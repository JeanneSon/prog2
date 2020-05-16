/**
 * NumberCruncherAnonym
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class NumberCruncherAnonym
{
    //Klassenkonstanten
    private static final String OPERATION_NOT_VALID = "Ungueltige Operation: ";
    //Objektattribute
    private float[] values;
    
    /**
    * Konstruktor
    * @param values Array, auf dem operiert werden soll
    */
    public NumberCruncherAnonym(float[] values)
    {
        this.values = values;
    }
  
    public void crunch(String[] operations) throws IllegalArgumentException
    {
        CrunchOperation swirl = new CrunchOperation() {
            public void crunch(float values[]){
                int n = values.length;
                int firstPos, secondPos;
                float aux;
                for (int i = 0; i < n; i++) {
                  firstPos = randomPos(n-1);
                  secondPos = randomPos(n-1);
                  aux = values[firstPos];
                  values[firstPos] = values[secondPos];
                  values[secondPos] = aux;
                }
            }
            private int randomPos(int highestIndex) 
            {
                return (int) Math.round(highestIndex * Math.random());
            }
        };  
        CrunchOperation divide   = new CrunchOperation(){
            public final float EPSILON = 10e-6F;
            public void crunch(float values[])
            {
                int[] indexes = new int[values.length];
                for (int i = 1; i < values.length; i++) {
                  indexes[i] = i;
                }
                float[] sortedValues = new float[values.length];
                System.arraycopy(values, 0, sortedValues, 0, 3);
                sortedValues = insertionSort(sortedValues, indexes);
                for (int i = 0, j = values.length-1; i < values.length / 2; i++, j--) {
                    if (Math.abs(sortedValues[i]) < EPSILON)
                      continue;
                    values[j] = sortedValues[j] / sortedValues[i];
                }
            }
            public float[] insertionSort(float tab[], int ind[])
            {
                int l = tab.length; 
                int temp2, j;
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
        };
        CrunchOperation average  = new CrunchOperation(){
            public void crunch(float values[]) {
                int indexLargestVal = 0;
                int sum = 0;
                for (int i = 0; i < values.length; i++) {
                  if (values[i] > values[indexLargestVal])
                    indexLargestVal = i;
                  sum += values[i];
                }
                values[indexLargestVal] = sum / values.length;
            }
        };
        CrunchOperation sum  = new CrunchOperation(){
            public void crunch(float values[]) {
                int l = values.length;
                for(int i = 1; i < l; i++){
                    values[i] = values[i-1] + values[i];
                }
            }
        };
        CrunchOperation subtract  = new CrunchOperation(){
            public void crunch(float values[]) {
                int l = values.length; 
                for(int i = 1; i < l; i++){
                    values[i] = values[i-1] - values[i];
                }
            }
        };
        for (String op : operations) {
            op = op.trim().toLowerCase();
            switch(op) {
              case "sum":
                 sum.crunch(values);
                 break;
              case "swirl":
                swirl.crunch(values);
                break;
              case "divide":
                divide.crunch(values);
                break;
              case "subtract":
                subtract.crunch(values);
                break;
              case "average":
                average.crunch(values);
                break;
              default:
                throw new IllegalArgumentException(OPERATION_NOT_VALID + op);
            }
        }
    }
    
    
    public float[] getNumbers()
    {
        return values;
    }
}