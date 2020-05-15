public class Average implements CrunchOperation
{
  private Average();
  
  public static void crunch(float values[])
  {
    int indexLargestVal = 0;
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[i] > values[indexLargestVal])
        indexLargestVal = i;
      sum += values[i];
    }
    values[indexLargestVal] = sum / values.length;
  }
}
