package Modul9;

//import jdk.internal.util.ArraysSupport;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue <E>{
    private final static int CAPACITY = 10;
    private final Object[] DEFAULT_DATA = {};
    private E[] items;
    private int head;
    private int tail;
    private int size;

    {   head = 0;
        tail = 0;
        size = 0;}
    public MyQueue() {
        items = (E[]) new Object [CAPACITY];
    }

    public MyQueue(int initSize) {
        items = (E[]) new Object[initSize];
    }
    public void add(E item) {
        if (size == items.length) {
            grow(items.length * 2);
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size++;
    }

    private void grow(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[(head + i) % items.length];
        }
        items = newArray;
        head = 0;
        tail = size;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return items[head];
    }
    public E poll() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        E item = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size--;
        if (size > 0 && size == items.length / 4) {
            grow(items.length / 2);
        }
        return item;
    }
    public int size(){
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            items[(head + i) % items.length] = null;
        }
        head = 0;
        tail = 0;
        size = 0;
    }
}
