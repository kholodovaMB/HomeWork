package Modul9;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class MyArrayList <E> extends AbstractList<E> implements List<E> {
    private final static int CAPACITY = 10;
    private int size = 0;
    private Object[] DEFAULT_DATA = {};
    transient Object[] elementData;

//    public MyArrayList() {
//        E[] DEFAULT_DATA;
//        DEFAULT_DATA = new E[10];
//    }

    public MyArrayList(int initSize) {
        if (initSize > 0) {
            this.elementData = new Object[initSize];
        } else if (initSize == 0) {
            this.elementData = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initSize);
        }
    }

    public MyArrayList(List<? extends E> data) {
        this.size = data.size();

    }

    @Override
    public int size() {
        return 0;
    }

    private boolean add() {
        return add(null);
    }

//    private boolean add(E e) {
//
//    }

    @Override
    public E get(int index) {
        return null;
    }

//    private void add(E e, Object[] elementData, int s) {
//        if (s == elementData.length)
//            elementData = grow();
//        elementData[s] = e;
//        size = s + 1;
//    }

//    private Object[] grow() {
//        return grow(size + 1);
//    }

//    private Object[] grow(int minCapacity) {
//        int oldCapacity = elementData.length;
//        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            int newCapacity = ArraysSupport.newLength(oldCapacity,
//                    minCapacity - oldCapacity, /* minimum growth */
//                    oldCapacity >> 1           /* preferred growth */);
//            return elementData = Arrays.copyOf(elementData, newCapacity);
//        } else {
//            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
//        }
//    }
}
