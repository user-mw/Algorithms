package com.workout.algorithms.data_structures.queue;

import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.Iterator;

public class PriorityArrayQueue<T extends Comparable> implements Iterable {
    private T[] mItems;
    private int mSize;
    private int mMaxSize;

    public PriorityArrayQueue(int maxSize) {
        if(maxSize < 0) {
            throw new IllegalArgumentException("Max size can not be less than zero");
        }

        mItems = (T[])Array.newInstance(Comparable.class, maxSize);
        mMaxSize = maxSize;
        mSize = 0;
    }

    public void insert(T item) {
        int step;

        if(mSize == 0) {
            mItems[mSize] = item;
        } else {
            for(step = mSize - 1; step >= 0; step--) {
                if(item.compareTo(mItems[step]) > 0) {
                    mItems[step + 1] = mItems[step];
                } else {
                    break;
                }
            }
            mItems[step + 1] = item;
        }
        mSize++;
    }

    public T delete() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        mSize--;
        return mItems[mSize];
    }

    public T peekMin() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return mItems[mSize - 1];
    }

    public T peekMax() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return mItems[0];
    }

    @NonNull
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int mStep = 0;

            @Override
            public boolean hasNext() {
                return mItems[mStep] != null;
            }

            @Override
            public Object next() {
                T result = mItems[mStep];
                mStep++;
                return result;
            }
        };
    }

    public int size() {
        return mSize;
    }
}
