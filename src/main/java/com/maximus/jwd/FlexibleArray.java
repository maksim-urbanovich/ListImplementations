package com.maximus.jwd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
        }
    }
}
