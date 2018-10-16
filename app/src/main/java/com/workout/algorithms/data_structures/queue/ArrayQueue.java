package com.workout.algorithms.data_structures.queue;

import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T> {
    private int mSize;
    private T[] mItems;
    private int mFirstIndex = 0;
    private int mLastIndex = -1;

    public ArrayQueue() {
        mItems = (T[]) Array.newInstance(Object.class, 4);
    }

    public void add(T item) {
        if(mSize == mItems.length) {
            growArray();
        }

        if(mLastIndex == mItems.length - 1) {
            mLastIndex = -1;
        }

        mLastIndex++;
        mItems[mLastIndex] = item;
        mSize++;
    }

    public T remove() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T result = mItems[mFirstIndex];
        mFirstIndex++;

        if(mFirstIndex == mItems.length - 1) {
            mFirstIndex = 0;
        }

        mSize--;
        return result;
    }

    public T peek() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return mItems[mFirstIndex];
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int mStep = mFirstIndex;

            @Override
            public boolean hasNext() {
                return mItems[mStep] != null;
            }

            @Override
            public T next() {
                T result = mItems[mStep];
                mStep++;
                return result;
            }
        };
    }

    public int size() {
        return mSize;
    }

    private void growArray() {
        int newLength = (mSize * 3) / 2 + 1;

//        int newLength = 4;
//        if(mSize > 0) {
//            newLength = mSize * 2;
//        }

        T[] newArray = (T[])Array.newInstance(Object.class, newLength);

        if(mSize > 0) {
            int targetIndex = 0;

            if(mLastIndex < mFirstIndex) {
                for(int step = mFirstIndex; step < mItems.length; step++) {
                    newArray[targetIndex] = mItems[step];
                    targetIndex++;
                }
                for(int step = 0; step <= mLastIndex; step++) {
                    newArray[targetIndex] = mItems[step];
                    targetIndex++;
                }
            } else {
                for(int step = mFirstIndex; step <= mLastIndex; step++) {
                    newArray[targetIndex] = mItems[step];
                    targetIndex++;
                }
            }

            mFirstIndex = 0;
            mLastIndex = targetIndex - 1;
        } else {
            mFirstIndex = 0;
            mLastIndex = -1;
        }

        mItems = newArray;
    }
}
