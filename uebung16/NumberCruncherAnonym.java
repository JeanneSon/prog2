//here are the anonymous functions of the operations
public class NumberCruncherAnonym
{
  //Objektattribute
  private float[] values;
  
  /*
   * Konstruktor
   * @param values Array, auf dem operiert werden soll
   */
  public NumberCruncherAnonym(float[] values)
  {
    this.values = values;
  }
  
  public void crunch(String[] operations) 
  {
    CrunchOperation swirl = new CrunchOperation(){
	public void crunch(){
		int n = values.length;
		int aux, firstPos, secondPos;
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
          int[] indexes = new int[];
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
    
  public float[] getNumbers()
  {
    return values;
  }
