import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * Beschreiben Sie hier die Klasse DoppeltVerketteteListe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class DoppeltVerketteteListe<T> implements List<T> {

    private ListNode<T> front;

    private int size;

    public DoppeltVerketteteListe() {
        front = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(T e) {
        if (this.isEmpty())
            front = new ListNode<T>(e);
        else {
            ListNode<T> temp = front;
            // Traverse till end of list
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode<T>(temp, e, null);
        }
        size++;
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
