package Modul9;

import java.util.Objects;

public class MyStack <E>{
    private final static int CAPACITY = 10;
    private E[] data;
    private int size;
    {
        size = 0;
    }
    public MyStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public MyStack(int initSize) {
        data = (E[]) new Object[initSize];
    }

    public void push(E item) {
        if (size == data.length) {
            grow(data.length * 2);
        }
        size++;
        data[size] = item;
    }

    public E remove(int index) {
//        Objects.checkIndex(index, size);
        if (index < 0 || index > size) {
            System.out.println("Don't exist element");
            return null;
        }
        E value = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        return value;
    }
    public E peek(){
        if (size == -1) {
            return null;
        }
        return  data[size];
    }
    public E pop() {
        if (size == -1) {
            return null;
        }

        E value = data[size];
        data[size] = null;
        size--;
        return value;
    }

    private void grow(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public int size(){
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}
