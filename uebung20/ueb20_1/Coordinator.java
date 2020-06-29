import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.AbstractQueue;
import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Coordinator.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Coordinator
{
    private Producer p;
    public Consumer c;
    private AbstractQueue<Integer> collect;
    
    
    public void start(String variante) throws IllegalArgumentException{ 
        if (variante.equals("FIFO")) {
            collect = new ConcurrentLinkedQueue<Integer>();
        }
        else if (variante.equals("natuerlich")) {
            collect = new PriorityQueue<Integer>();
        }
        else {
            throw new IllegalArgumentException("argument not valid; put either \"FIFO\" or \"natuerlich\"");
        }
            
        p = new Producer();
        c = new Consumer();
        
        Random ran = new Random();
        for(int i = 0; i<10000; i++) {
            if (ran.nextInt(2) > 0 ) {
                collect.add(p.produce());
            } else {
                if (collect.isEmpty())
                    continue;
                c.consume(collect.remove());
            }
        }
    }
    
    
    public static void main(String[] args) {
        String variante = args[0];
        new Coordinator().start(variante);
    }
}