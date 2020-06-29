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
    private TreeMap<Integer, ArrayList<Long>> map;
    
    /**
     * Konstruktor für Objekte der Klasse Consumer
     */
    public Consumer()
    {
        map = new TreeMap<Integer, ArrayList<Long>>();
    }

    /**
     * 
     * @param  i ein zufallige Zahl zwishcne 0 und 1000
     */
    public void consume(int i)
    {
        int quersumme = 0;
        while(i > 0) {
            int digit = i%10;
            quersumme += digit;
            i /= 10;
        }
        long time = System.currentTimeMillis();
        neuerEintrag(quersumme, time);
        //stecke Quersumme und Time in Map
    }
    
    
    
    private void neuerEintrag (int quersumme, long time) {
        ArrayList<Long> array = new ArrayList();
        if (map.containsKey(quersumme)){
            Object qs = (Integer) quersumme;
            array = map.get(qs);
            array.add(time);
            map.put(quersumme, array);
        }
        else { 
            array.add(time);
            map.put(quersumme, array);
        }
    }
    
    public int numberOfDifferentResults(){
        return map.size();
    }
    
    public int numberOfOccurrences(int i){
        if (map.containsKey(i)){
            Object qs = (Integer) i;
            return map.get(qs).size();
        }
        else
            return -1;
    }
    
    public Collection<Integer> getCrossTotalsDescending(){
        return map.descendingKeySet();
    }
    
    public Collection<Integer> getCrossTotalsAscending() {
        return map.keySet();
    }
    
    public Collection<Long> getTimestampsForResult(int i){
        if (map.containsKey(i)){
            Object qs = (Integer) i;
            return map.get(qs);
        }
        else
            System.out.println("Gegebene Quersumme nicht gespeichert");
            return null;
    }
    //gibt collection zurück ArrayList
}