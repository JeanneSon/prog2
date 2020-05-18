import java.util.ArrayList;
import java.util.Iterator;
/**
 *    ----> PersonQueue
 *          --> Implementierung einer PersonQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly erweitert von A. Venet & H. Schall
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
   
   /**
     * PersonIter
     * iteriert ueber PersonQueue
     * 
     * @author A. Venet u. H. Schall
     * @version 1.0
     */
   private class PersonIter implements PersonIterator 
   {
       private int index;
       
       /**
        * PersonIter Konstruktor
        * setzt den Index auf 0
        */
       public PersonIter()
       {
             index = 0;
       }
       
       /**
        * Methode hasNext
        *
        * @return ob PersonQueue ein weiteres Element besitzt
        */
       public boolean hasNext()
       {
           return PersonQueue.super.size() - index > 0;
       }
       
       /**
        * Methode next
        *
        * @return das naechste Element
        */
       public Person next()
       {
              return get(index++);
       }
   }
   /**
     * Methode toString
     * @return Aufbereitung des Objekts als Zeichenkette
     */
   public String toString(){
       StringBuffer sb = new StringBuffer("PersonQueue: ");
       PersonIter iterator = new PersonIter();
       while (iterator.hasNext()) {
           sb  .append(iterator.next())
               .append(" -> ");
       }
       return sb.toString();
   }
   
   /**
     * smallest
     * @return gibt die Person, die von allen Wartenden den lexikalisch kleinsten Vornamen hat, als String zurueck
    */
   public String smallest (){
       if (super.empty()) {
           return "";
       }
       PersonIter iterator = new PersonIter();
       Person smallest = iterator.next();
       while (iterator.hasNext()) {
           Person test = iterator.next();
           int compare = smallest.getVorname().compareTo(test.getVorname());
           if (compare > 0)
                smallest = test;
       }
       return smallest.toString();
   }
}