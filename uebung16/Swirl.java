class Swirl implements CrunchOperation {
  private Swirl ();
  
  public static void crunch (float values[]) 
  {
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
  
  private static int randomPos(int highestIndex) 
  {
    return (int) Math.round(highestIndex * Math.random());
  }
  
  String toString()
  {
    return "Swirl fuehrt n zufaellige Vertauschungen der Datenfelder durch; n ist durch die Laenge des ﬂoat-Arrays gegeben.";
  }
