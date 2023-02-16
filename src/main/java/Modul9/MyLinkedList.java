package Modul9;
// https://habr.com/ru/post/337558/
import java.util.LinkedList;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class MyLinkedList <E>{
    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public MyLinkedList() {
    }
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        //modCount++;
    }

    public void add(E value) {
        Node<E> node = new Node<>(value);
        Node<E> last = first;
        if (first == null) {
            last = node;
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
            counter++;
        }
    }
    public void add(E e) {
        checkForComodification();
        lastReturned = null;
        if (next == null)
            linkLast(e);
        else
            linkBefore(e, next);
        nextIndex++;
        expectedModCount++;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public void clear() {

        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Nodes<T> node = head;
        int step = 0;
        while (head != null) {
            if (index == step & step <= counter) {
                return node.item;
            }
            node = node.next;
            step++;
        }
        throw new IndexOutOfBoundsException();
    }

    public T remove(int index) {
        Nodes<T> node = head;
        Nodes<T> nextNode = null;
        T el = null;

        int step = 0;
        while (node != null) {
            if (index == step) {
                if (node == head) {
                    el = node.item;
                    node = node.next;
                    head = node;
                } else {
                    nextNode.next = node.next;
                    el = node.item;
                }
            }
            nextNode = node;
            node = node.next;
            step++;
        }

        if( el == null)
            throw new IndexOutOfBoundsException();

        counter--;
        return el;
    }

    @Override
    public String toString() {
        StringBuilder write = new StringBuilder();
        Nodes<T> node = head;
        if (node == null) {
            write.append("Head null");
        } else while (node != null) {
            write.append(node.item).append("\t");
            node = node.next;
        }
        return write.toString();
    }

    public int size() {
        return counter != 0?counter + 1: 1;
    }

    public void clear() {
        Nodes<T> node = head;
        while (head != null & counter != 0) {
            node.next = null;
            node.item = null;
            head = null;
            counter--;
        }
    }
}
