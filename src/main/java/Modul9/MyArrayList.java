package Modul9;

import java.util.*;
import jdk.internal.util.ArraysSupport;

public class MyArrayList <E> {
    private final static int CAPACITY = 10;
    private int size;
    private final Object[] DEFAULT_DATA = {};
    transient Object[] elementData;
    public MyArrayList() {
        this.elementData = DEFAULT_DATA;
    }

    public MyArrayList(int initSize) {
        if (initSize > 0) {
            this.elementData = new Object[initSize];
        } else if (initSize == 0) {
            this.elementData = DEFAULT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initSize);
        }
    }

//    public MyArrayList(Collection <? extends E> data) {
//        this.size = data.size();
//        Object[] a = data.toArray();
//        if (size != 0) {
//                elementData = Arrays.copyOf(a, size, Object[].class);
//            }
//         else {
//            elementData = DEFAULT_DATA;
//        }
//    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        if (size == elementData.length)
            elementData = grow(size + 1);
        elementData[size] = e;
        size++;
        return true;
    }

    public E get(int index) {
        if (index < size) {
            return (E) elementData[index];}
        else {
            System.out.println("Don't exist element");
        }
        return null;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULT_DATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(CAPACITY, minCapacity)];
        }
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        final int newSize;
        if ((newSize = size - 1) > index){
            System.arraycopy(es, index + 1, es, index, newSize - index);
        es[size = newSize] = null;}

        return oldValue;
    }

    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }
}
