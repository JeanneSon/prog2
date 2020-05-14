public class Operator
{
    // Fehlermeldungen
    private static final String MSG_ARRAY_LEER = "Array darf nicht leer sein!";
    /**
     * 
     */
    public double[] sum(double[] tab)
    {
        int l = tab.length;
        check(l != 0, MSG_ARRAY_LEER);  
        for(int i = 1; i < l; i++){
            tab[i] = tab[i-1] + tab[i];
        }
        return tab;
    }
    
    /**
     * 
     */
    public double[] substract(double[] tab)
    {
        int l = tab.length;
        check(l != 0, MSG_ARRAY_LEER);  
        for(int i = 1; i < l; i++){
            tab[i] = tab[i-1] - tab[i];
        }
        return tab;
    }
    
    private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
}
