/**
 * Sum
 * 
 * @author A. Venet u. H. Schall
 * @version (eine Versionsnummer oder ein Datum)
 */
class Sum implements CrunchOperation {
  // Fehlermeldungen
  private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";
  public void crunch (float values[]) 
  {
    int l = values.length;
    check(l != 0, MSG_ARRAY_LEER);  
    for(int i = 1; i < l; i++){
        values[i] = values[i-1] + values[i];
    }
  }  
  public String toString()
  {
    return "Summiert die Elemente des Arrays paarweise von links nach rechts D.h.: a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw.";
  }
  private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
