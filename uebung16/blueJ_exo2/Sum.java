/**
 * Sum
 * 
 * @author A. Venet u. H. Schall
 * @version 1.0
 */
class Sum implements CrunchOperation {
    // KLASSENKONSTANTEN
    // Fehlermeldungen
    private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";
      
    
    /**
     * Methode crunch
     * Summiert die Elemente des Arrays paarweise von
     * links nach rechts D.h.: a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw.
     * 
     * @param values uebergebendes Array, das veraendert wird (s.o.)
     */
    public void crunch (float values[]) 
    {
        int l = values.length;
        check(l != 0, MSG_ARRAY_LEER);  
        for(int i = 1; i < l; i++){
            values[i] = values[i-1] + values[i];
        }
    }  
    
    /**
    * Methode toString
    * @return informiert ueber die Klasse Sum
    */  
    public String toString()
    {
        return "Summiert die Elemente des Arrays paarweise von " + 
            "links nach rechts D.h.: a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw.";
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