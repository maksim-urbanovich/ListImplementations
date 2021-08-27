package com.maximus.jwd;

import java.util.*;

public class FlexibleArray<E> implements Cloneable{
    private final static int INITIAL_CAPACITY = 10;

    private final static Object[] EMPTY_ELEMENTDATA = {};
    private final static Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public FlexibleArray() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENTDATA;
    }

    public FlexibleArray(int capacity) {
        if (capacity > 0) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }
        else {
            throw new IllegalArgumentException("Wrong list capacity" + capacity);
        }
    }

    public FlexibleArray(Collection<? extends E> collection) {
        this.elementData = collection.toArray();
        if (elementData.length == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else {
            elementData = Arrays.copyOf(elementData, elementData.length, Object[].class);
        }
    }

    private void add (E element, Object[] elementData, int s) {
        if (s == elementData.length) {
            elementData = grow();
        } else {
            elementData[s] = element;
            size++;
        }
    }

    private Object[] grow() {

    }

    public void add(E element) {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(object.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains (Object object) {
        return (indexOf(object) != -1);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bound");
        } else {
            return (E) elementData[index];
        }
    }

    public E set(int index, E newValue) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bound");
        } else {
            E oldValue = (E) elementData[index];
            elementData[index] = newValue;
            return oldValue;
        }
    }
}
