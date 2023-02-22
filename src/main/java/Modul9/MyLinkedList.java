package Modul9;
// https://habr.com/ru/post/337558/
import java.util.LinkedList;

public class MyLinkedList <E>{
    transient int size;
    transient Node<E> head;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
        public boolean add(E element) {
            Node<E> newNode = new Node<>(element);
            if (head == null) {
                head = newNode;
            } else {
                Node<E> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
            return true;
        }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        Node<E> node = head;
        Node<E> nextNode = null;
        E element = null;

        int step = 0;
        while (node != null) {
            if (index == step) {
                if (node == head) {
                    element = node.data;
                    node = node.next;
                    head = node;
                } else {
                    nextNode.next = node.next;
                    element = node.data;
                }
            }
            nextNode = node;
            node = node.next;
            step++;
        }

        if( element == null)
            throw new IndexOutOfBoundsException();

        size--;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<E> node = head;
        if (node == null) {
            str.append("Head null");
        } else while (node != null) {
            str.append(node.data).append("\t");
            node = node.next;
        }
        return str.toString();
    }

    public void clear() {
        Node<E> node = head;
        while (head != null & size != 0) {
            node.next = null;
            node.data = null;
            head = null;
            size = 0;
        }
    }
}
