
/**
 * Beschreiben Sie hier die Klasse Node.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class ListNode<E> {
    // aktuelle Daten
    E data;
    // Referenz auf nächtes Node
    ListNode<E> next;
    // Referenz auf vorheriges Node
    ListNode<E> prev;
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
}