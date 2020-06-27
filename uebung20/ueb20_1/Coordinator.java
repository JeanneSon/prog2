/**
 * Beschreiben Sie hier die Klasse Coordinator.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Coordinator
{
    private Producer p;
    private Consumer c;
    
    
    private void start() {
        p = new Producer();
        c = new Consumer();
        
        // collection hier sind die integers drin
    //falls Variante == FIFO, dann: concurrent queue
    //falls variante == natürliche sortierung: priority queue
        
        //Random ran = new Random(); for(int i = 0; i<10000; i++) { if(ran.nextInt(2) > 0 ) // Erzeugen eines neuen Integers durch den Producer und speichern // in einer Collection else // Entnehmen eines Integeres aus der Collection und Berechnung der // Quersumme durch den Consumer }

    }
    
    
    public static void main(String[] args) {
        String variante = args[0];
        new Coordinator().start(variante);
    }
}