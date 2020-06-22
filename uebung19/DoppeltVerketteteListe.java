import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoppeltVerketteteListe<E> implements List<E> {
    
    private ListNode<E> front;

    private int size;

    public DoppeltVerketteteListe() {
        front = null;
        size = 0;
    }
    
    @Override
    public boolean add(T e) {
        if (isEmpty())
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
    public void add(int arg0, E arg1) {
        
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        return false;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        
    }

    @Override
    public boolean contains(Object arg0) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object arg0) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean remove(Object arg0) {
        return false;
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
    public int size() {
        int size = 0;
        ListElement e = first;
        while(e != null) {
            e = e.getNext();
            size++;
        }
        return size;
    }

    @Override
    public List<E> subList(int arg0, int arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        return null;
    }

      @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

}