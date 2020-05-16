/**
 * Averag.
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
public class Average implements CrunchOperation
{  
  /**
   * Bestimmt den Durchschnitt aller Werte im Array und 
   * speichert den Durchschnittswert im Datenfeld mit dem groessten Wert. 
   *
   * @param values das Array, das veraendert wird (s.o.)
   */
  public void crunch(float values[])
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
}
