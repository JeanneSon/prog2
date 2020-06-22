
/**
 * Beschreiben Sie hier die Klasse Node.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class ListNode<E> {
    // aktuelle Daten
    private E data;
    // Referenz auf nächtes Node
    private ListNode<E> next;
    // Referenz auf vorheriges Node
    private ListNode<E> prev;
    /**
     * Konstruktor.
     * set to null => Anfang
     *
     * @param data node data
     */
    ListNode(E data) {
        this(null, data, null);
    }
    /**
     * Konstruktor.
     *
     * @param data node data
     * @param next reference to next node
     * @param prev reference to the previous node
     */
    ListNode(ListNode<E> prev, E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    // set-Methoden
     
    /**
     * setPrev
     *
     * @param prev der Node, der von nun an der Vorgänger ist
     */
    public void setPrev(ListNode<E> prev) {
        this.prev = prev;
    }
    
    /**
     * setNext
     *
     * @param next der Node, der von nun an der Nachfolger ist
     */
    public void setNext(ListNode<E> next) {
        this.next = next;
    }
    
    // get-Methoden
    
    
    /**
     * getData gibt den Wert, der in diesem Knoten gespeichert ist, zurueck
     *
     * @return gespeicherter Wert
     */
    public E getData() {
        return this.data;
    }
}