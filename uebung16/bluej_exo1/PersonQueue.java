import java.util.ArrayList;
import java.util.Iterator;
/**
 *    ----> PersonQueue
 *          --> Implementierung einer PersonQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly
 *
 */

public class PersonQueue 
       extends ObjectQueue
{
   private static final String  KEIN_PERSON_OBJEKT = "Das einzufuegende Objekt ist KEIN Person-Objekt !!";
   /** der Konstruktor
    *
    */
   public PersonQueue(int laenge) {
       super(laenge);
   }
   
   /** Ein Person-Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   @Override
   public void addLast (Object o) 
   {
     if ( o instanceof Person )
       {
        super.addLast( o );
       }
     else
       {
         throw new RuntimeException(KEIN_PERSON_OBJEKT);
       }
   }

   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das Person-Element an der Spitze der Queue
    */
   @Override
   public Person removeFirst () 
   {
     return (Person)super.removeFirst();
   }

   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   @Override
   public Person get ( int i ) 
   {
       return (Person)super.get(i);
   }
   
   interface PersonIterator extends java.util.Iterator<Person> {}
   
   public class PersonIter implements PersonIterator 
   {
       private int index;
       
       public PersonIter()
       {
              index = 0;
       }
       
       public boolean hasNext()
       {
              return PersonQueue.super.size() - index > 1;
       }
       
       public Person next()
       {
              return get(index++);
       }
   }
   /**
     * 
    */
   public String toString(){
       StringBuffer sb = new StringBuffer("PersonQueue: ");
       PersonIter iterator = new PersonIter();
       while (iterator.hasNext()) {
           sb  .append(iterator.next())
               .append("\n");
       }
       return sb.toString();
   }
   
   /**
     * 
    */
   public Person smallest (){
       PersonIter iterator = new PersonIter();
       Person smallest = iterator.next();
       while (iterator.hasNext()) {
           Person test = iterator.next();
           int compare = smallest.compareTo(test);
           if (compare > 0)
                smallest = test;
            }
       return smallest;
   }
}