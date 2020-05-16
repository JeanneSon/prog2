public class Average implements CrunchOperation
{
  /**
   * Konstruktor ist private, damit keine Objekte von der Klasse angelegt werden koennen
   */
  private Average();
  
  /**
   * Bestimmt den Durchschnitt aller Werte im Array und 
   * speichert den Durchschnittswert im Datenfeld mit dem groessten Wert. 
   *
   * @param values das Array, das veraendert wird (s.o.)
   */
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
  
  /**
   * gibt die Aufgabe der Klasse als String zurueck
   *
   * @return String
   */
   public static String toString()
   {
    return "Bestimmt den Durchschnitt aller Werte im Array und"
           + "speichert den Durchschnittswert im Datenfeld mit dem groessten Wert.";
   }   
}
