package com.workout.algorithms.data_structures.array_list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayList<T> {
    private T[] mItems;
    private int mSize;

    public CustomArrayList() {
        mItems = (T[]) Array.newInstance(Object.class, 0);
    }

    public CustomArrayList(int newLength) {
        if(newLength < 0) {
            throw new IllegalArgumentException("Length can not be less than zero.");
        }

        mItems = (T[]) Array.newInstance(Object.class, newLength);
    }

    public T get(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index can not be less than zero.");
        }
        if(index >= mSize) {
            throw new IndexOutOfBoundsException();
        }

        return mItems[index];
    }

    public void set(int index, T newValue) {
        if(index < 0) {
            throw new IllegalArgumentException("Index can not be less than zero.");
        }
        if(index >= mSize) {
            throw new IndexOutOfBoundsException();
        }

        mItems[index] = newValue;
    }

    public void add(T item) {
        if(mSize == mItems.length) {
            growArray();
        }

        mItems[mSize] = item;
        mSize++;
    }

    public int size() {
        return mSize;
    }

    private void growArray() {
        int newLength = (mItems.length * 3) / 2 + 1; // java variant

//        one more variant
//        int newLength = 4;
//
//        if(mItems.length > 0) {
//            newLength *= 2;
//        }

        mItems = Arrays.copyOf(mItems, newLength);
    }
}
