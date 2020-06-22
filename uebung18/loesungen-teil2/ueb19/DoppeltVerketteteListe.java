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

    private int size;

    public DoppeltVerketteteListe() {
        head = new ListNode(null);
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
                return a;
            else {
                a[0] = null;
                return a;
            }
        if (a.length == this.size) {
            return makeArray(a);
        }
        if (a.length < this.size) {
            T[] result = (T[])new Object[this.size];
            return makeArray(result);
        }
        else {
            makeArray(a);
            a[this.size] = null;
            return a;
        }
    }

    
    private <T> T[] makeArray(T[] a) {
        ListNode<E> currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
                a[index] = (T) currentNode.getData();
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
        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListNode<E> currentNode = this.head;
        do {
            if (currentNode.getData().equals(o)) {
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != null);
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) throws ClassCastException{
        Iterator iter = c.iterator();
        ListNode<E> last = getLast();
        while (iter.hasNext()) {
            ListNode<E> next = new ListNode<E>((E) iter.next());
            last.setNext(next);
            next.setPrev(last);
            last = next;
        }
        size += c.size();
        return c.isEmpty();
    }
    
    private ListNode<E> getLast() {
        int acc = 0;
        int index = size() - 1;
        ListNode<E> currentNode = this.head;
        while (acc < index) {
            currentNode = currentNode.getNext();
            acc++;
        }
        return currentNode;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        int acc = 0;
        ListNode<E> currentNode = this.head;
        while (acc < index) {
            currentNode = currentNode.getNext();
            acc++;
        }
        return currentNode.getData();
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        int acc = 0;
        ListNode<E> currentNode = this.head;
        while (acc < index) {
            currentNode = currentNode.getNext();
            acc++;
        }
        E oldElement = currentNode.getData();
        currentNode.setData(element);
        return oldElement;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        int acc = 0;
        ListNode<E> currentNode = this.head;
        while (acc < index) {
            currentNode = currentNode.getNext();
            acc++;
        }
        ListNode<E> newNode = new ListNode<E>(element);
        newNode.setPrev(currentNode.getPrev());
        newNode.setNext(currentNode);
        currentNode.setPrev(newNode);
    }

    @Override
    public E remove(int index)  throws IndexOutOfBoundsException{
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        int acc = 0;
        ListNode<E> currentNode = this.head;
        while (acc < index) {
            currentNode = currentNode.getNext();
            acc++;
        }
        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
        return currentNode.getData();
    }

    @Override
    public int indexOf(Object o) throws ClassCastException{
        E searched = (E) o;
        int index = 0;
        ListNode<E> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(searched))
                return index;
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
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
