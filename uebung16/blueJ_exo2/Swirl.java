/**
 * Swirl
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
class Swirl implements CrunchOperation {
    
  // KLASSENKONSTANTEN
  // Fehlermeldungen
  private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";
    
  /**
   * Methode crunch
   * fuehrt n zufaellige Vertauschungen der Datenfelder
   * durch; n ist durch die Laenge des ﬂoat-Arrays gegeben
   *
   * @param values float-Array, auf dem operiert wird
   */
  public void crunch (float values[]) 
  {
    int n = values.length;
    check(n != 0, MSG_ARRAY_LEER); 
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
  
  /**
   * Methode randomPos
   * gibt einen zufaelligen Index zwischen 0 und highestIndex zurueck
   *
   * @param highestIndex hoechstmoeglicher Index
   * @return zufelliger Index
   */
  private static int randomPos(int highestIndex) 
  {
    return (int) Math.round(highestIndex * Math.random());
  }
  
  /**
   * toString
   * @return informiert ueber die Aufgabe der Klasse
   */
  public String toString()
  {
    return "Swirl fuehrt n zufaellige Vertauschungen der Datenfelder " + 
            "durch; n ist durch die Laenge des ﬂoat-Arrays gegeben.";
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