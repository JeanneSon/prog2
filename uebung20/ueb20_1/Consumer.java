import java.util.*; 
import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Consumer.
 * 
 * @author VENET Aurianne & SCHALL Hanna
 * @version 1.0
 */
public class Consumer
{
    
    //private Map enthaelt Collection; // -> ArrayList // -> TreeMap;
    static TreeMap<Integer, ArrayList<String>> map;
    /**
     * Konstruktor für Objekte der Klasse Consumer
     */
    public Consumer()
    {
        // Instanzvariable initialisieren
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void consume(int i)
    {
        long beginTime = System.currentTimeMillis();
        int quersumme = 0;
        while(i > 0) {
            int digit = i%10;
            quersumme += digit;
            i /= 10;
        }
        long time = System.currentTimeMillis() - beginTime;
        neuerEintrag(quersumme, time);
        //stecke Quersumme und Time in Map
    }
    
    private void neuerEintrag (int i, long time) {
        ArrayList<String> array = new ArrayList();
        if (map.containsKey(i)){
            array.add(map.get(i));
            array.add(time);
            map.put(i, time);
        }
        else { 
            array.add(time);
            map.put(i, time);
        }
    }
    
    private int numberOfDifferentResults(){
        return map.size();
    }
    
    private int numberOfOccurrences(int i){
        if (map.containsKey(i)){
            return length(map.get(i));
        }
        else
            return -1;
    }
    
    private Collection<Integer> getCrossTotalsDescending(){
        ArrayList<String> array = new ArrayList();
        for (Map.Entry e : map.entrySet()){
            String element = e.getKey() + " "+ e.getValue();
            array.add(element);
        }
        return array;
    }
    
    private Collection<Integer> getCrossTotalsAscending() {
    }
    
    private Collection<Long> getTimestampsForResult(int i){
        if (map.containsKey(i)){
            return map.get(i);
        }
        else
            // message d'erreur
            ;
    }
    //gibt collection zurück ArrayList
}