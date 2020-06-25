
/**
 * Beschreiben Sie hier die Klasse Node.
 * 
 * @author A.Venet u. H. Schall 
 * @version 1.0
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
     * @param prev der Node, der von nun an der Vorgaenger ist
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
    
    /**
     * setData
     *
     * @param Wert des Nodes, der von nun an der Wert ist
     */
    public void setData(E data) {
        this.data = data;
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
    
    /**
     * getPrev gibt den Vorgaenger-Node zurueck
     *
     * @return Vorgaenger
     */
    public ListNode<E> getPrev() {
        return this.prev;
    }
    
    /**
     * getNext gibt den Nachfolger-Node zurueck
     *
     * @return Nachfolger
     */
    public ListNode<E> getNext() {
        return this.next;
    }
    
}