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
    static TreeMap<Integer, ArrayList<String>> map;
    
    /**
     * Konstruktor für Objekte der Klasse Consumer
     */
    public Consumer()
    {
        // Instanzvariable initialisieren
    }

    /**
     * 
     * @param  i ein zufallige Zahl zwishcne 0 und 1000
     */
    public void consume(int i)
    {
        int quersumme = 0;
        long beginTime = System.currentTimeMillis();
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
            map.put(i, array);
        }
        else { 
            array.add(time);
            map.put(i, array);
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
        Collections.reverse(map);
        String[] reversed = listOfProducts.toArray(typesOfInsurance);
        System.out.println("array after reverse: " + Arrays.toString(reversed) );
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