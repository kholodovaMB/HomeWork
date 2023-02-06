package Modul9;

import java.util.*;
import jdk.internal.util.ArraysSupport;

public class MyArrayList <E>  extends AbstractList<E> implements List<E>{
    private final static int CAPACITY = 10;
    private int size;
    private final Object[] DEFAULT_DATA = {};
    transient Object[] elementData;
    private int modCount = 0;
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

    public MyArrayList(Collection <? extends E> data) {
        this.size = data.size();
        Object[] a = data.toArray();
        if (size != 0) {
            if (data.getClass() == MyArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elementData = DEFAULT_DATA;
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }


    public int size() {
        return size;
    }

    public boolean add(E e) {
        modCount++;
//        System.out.println("e = " + e);
//        System.out.println("modCount = " + modCount);
        add(e, elementData, size);
        return true;
    }

    @Override
    public E get(int index) {
        System.out.println(size);
        if (index < size) {
            return (E) elementData[index];}
        else {
            System.out.println("Don't exist element");
        }
        return null;}

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    private Object[] grow() {
        return grow(size + 1);
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
}
