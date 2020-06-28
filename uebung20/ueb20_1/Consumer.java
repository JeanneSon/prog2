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
        long time = 0;
        int quersumme = 0;
        while(i > 0) {
            int digit = i%10;
            quersumme += digit;
            i /= 10;
        }
        ArrayList<String> array[] = new ArrayList();
        if (map.containsKey(quersumme)){
            array.add(map.get(quersumme));
            array.add(time);
            map.put(quersumme, time);
        }
        else { 
            array.add(time);
            map.put(quersumme, time);
        }
        //stecke Quersumme und Time in Map
    }
    
    private void neuerEintrag (int i, long miliseconds) {
        //quersumme schon als schlüssel in treeMap?
        //falls ja -> miliseconds hinzufügen zur Arraylist von dieser quersumme
        //falls nein -> neuer eintrag mit quersumme als schlüssel und arraylist als wert; arraylist enthält miliseconds
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
    }
    
    private Collection<Integer> getCrossTotalsAscending() {
    }
    
    private Collection<Long> getTimestampsForResult(int i){
    }
    //gibt collection zurück ArrayList
}