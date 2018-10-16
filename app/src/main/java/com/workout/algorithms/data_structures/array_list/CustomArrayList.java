package com.workout.algorithms.data_structures.array_list;

import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {
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

    public void insert(int index, T item) {
        if(index < 0) {
            throw new IllegalArgumentException("Index can not be less than zero.");
        }
        if(index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        if(mSize == mItems.length) {
            growArray();
        }

        System.arraycopy(mItems, index, mItems, index + 1, mSize - index);
        mItems[index] = item;
        mSize++;
    }

    public boolean delete(T itemToDelete) {
        for(int step = 0; step < mItems.length; step++) {
            if(mItems[step].equals(itemToDelete)) {
                deleteAt(step);
                return true;
            }
        }
        return false;
    }

    public void deleteAt(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index can not be less than zero.");
        }
        if(index >= mSize) {
            throw new IndexOutOfBoundsException();
        }

        int shiftStart = index + 1;

        if(shiftStart < mSize) {
            System.arraycopy(mItems, shiftStart, mItems, index, mSize - shiftStart);
        }

        mSize--;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public int indexOf(T item) {
        for(int step = 0; step < mSize; step++) {
            if(mItems[step].equals(item)) {
                return step;
            }
        }

        return -1;
    }

    public void copyTo(T[] newArray, int newIndex) {
        System.arraycopy(mItems, 0, newArray, newIndex, mSize);
    }

    public int size() {
        return mSize;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int mStep = 0;

            @Override
            public boolean hasNext() {
                return mStep < mSize;
            }

            @Override
            public T next() {
                T result = mItems[mStep];
                mStep++;
                return result;
            }
        };
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
