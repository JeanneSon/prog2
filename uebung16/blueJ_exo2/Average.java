/**
 * Average
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class Average implements CrunchOperation
{  
    
  // KLASSENKONSTANTEN
  // Fehlermeldungen
  private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";  
  /**
   * Bestimmt den Durchschnitt aller Werte im Array und 
   * speichert den Durchschnittswert im Datenfeld mit dem groessten Wert. 
   *
   * @param values das Array, das veraendert wird (s.o.)
   */
  public void crunch(float values[])
  {
    int l = values.length;
    check(l != 0, MSG_ARRAY_LEER); 
    int indexLargestVal = 0;
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[i] > values[indexLargestVal])
        indexLargestVal = i;
      sum += values[i];
    }
    values[indexLargestVal] = sum / values.length;
  }
  
  /**
   * gibt die Aufgabe der Klasse als String zurueck
   *
   * @return String
   */
   public String toString()
   {
    return "Bestimmt den Durchschnitt aller Werte im Array und"
           + "speichert den Durchschnittswert im Datenfeld mit dem groessten Wert.";
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
