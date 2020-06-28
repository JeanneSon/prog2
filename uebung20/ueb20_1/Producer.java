import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Producer.
 * 
 * @author VENET Aurianne & SCHALL Hanna
 * @version 1.0
 */
public class Producer
{
   
    /**
     * Konstruktor für Objekte der Klasse Producer
     */
    public Producer()
    {
        
    }

    /**
     * 
     */
    public int produce()
    {
        Random random = new Random();
        int number = random.nextInt(1000);
        return number;
    }
}