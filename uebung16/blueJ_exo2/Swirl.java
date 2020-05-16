/**
 * Swirl
 * 
 * @author A. Venet u. H. Schall
 * @version (eine Versionsnummer oder ein Datum)
 */
class Swirl implements CrunchOperation {
  public void crunch (float values[]) 
  {
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
  
  private static int randomPos(int highestIndex) 
  {
    return (int) Math.round(highestIndex * Math.random());
  }
  
  public String toString()
  {
    return "Swirl fuehrt n zufaellige Vertauschungen der Datenfelder durch; n ist durch die Laenge des ﬂoat-Arrays gegeben.";
  }
}