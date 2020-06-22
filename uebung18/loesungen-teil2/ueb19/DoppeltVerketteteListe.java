import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse DoppeltVerketteteListe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class DoppeltVerketteteListe<E> implements List<E> {

    private ListNode<E> head;
    private ListNode<E> tail;

    private int size;

    public DoppeltVerketteteListe() {
        head = new ListNode(null);
        tail = new ListNode(null);
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        try {
            E item = (E) o;
            return containsRecurs(item, this.head);
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    private boolean containsRecurs(E item, ListNode<E> currentNode) {
        if (currentNode == null)
            return false;
        if (item.equals(currentNode.getData()))
            return true;
        return containsRecurs(item, currentNode.getPrev());
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        if (this.isEmpty())
            if (a.length == 0)
                return a;   //(E[])new Object[0];
            else {
                a[0] = null;
                return a;
            }
        if (a.length == this.size) {
            return makeArray(a);
        }    
        E[] result;
        
        ListNode<E> currentNode = this.head;
        if (a.length > this.size) {}
    }

    
    private <T> T[] makeArray(T[] a) {
        ListNode<E> currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
                a[index] = currentNode.getData();
                currentNode = currentNode.getNext();
                index++;
        }
        return a;   
    }
    
    @Override
    public boolean add(E e) {
        ListNode<E> newNode = new ListNode<E>(e);
        if (this.isEmpty())
            this.head = newNode;
        else {
            ListNode<E> currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            newNode.setPrev(currentNode);
            currentNode.setNext(newNode);
        }
        this.size++;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int arg0) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean removeAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int arg0, int arg1) {
        throw new UnsupportedOperationException();
    }
}
