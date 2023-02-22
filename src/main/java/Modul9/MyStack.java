package Modul9;

import java.util.Objects;

public class MyStack <E>{
    private final static int CAPACITY = 10;
    private E[] data;
    private int size;
    {
        size = -1;
    }
    public MyStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public MyStack(int initSize) {
        data = (E[]) new Object[initSize];
    }

    public void push(E item) {
        if (size == data.length - 1) {
            grow();
        }
        size++;
        data[size] = item;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        if (index == -1) {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    index);
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

        if (size < data.length / 2) {
            decreaseCapacity();
        }

        return value;
    }

    private void grow() {
        E[] newData = (E[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private void decreaseCapacity() {
        if (data.length > CAPACITY) {
            E[] newData = (E[]) new Object[data.length / 2];
            System.arraycopy(data, 0, newData, 0, newData.length);
            data = newData;
        }
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
