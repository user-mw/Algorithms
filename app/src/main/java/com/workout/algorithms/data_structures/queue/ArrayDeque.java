package com.workout.algorithms.data_structures.queue;

import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private int mSize;
    private T[] mItems;
    private int mFirstIndex = 0;
    private int mLastIndex = -1;

    public void addFirst(T item) {
        if(mItems == null || mSize == mItems.length) {
            growArray();
        }

        if(mFirstIndex > 0) {
            mFirstIndex--;
        } else {
            mFirstIndex = mItems.length - 1;
        }
        mItems[mFirstIndex] = item;
        mSize++;

        if(mSize == 1) {
            mLastIndex = mFirstIndex;
        }
    }

    public void addLast(T item) {
        if(mItems == null || mSize == mItems.length) {
            growArray();
        }

        if(mLastIndex == mItems.length - 1) {
            mLastIndex = 0;
        } else {
            mLastIndex++;
        }
        mItems[mLastIndex] = item;
        mSize++;

        if(mSize == 1) {
            mFirstIndex = mLastIndex;
        }
    }

    public T removeFirst() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T result = mItems[mFirstIndex];

        if(mFirstIndex == mItems.length - 1) {
            mFirstIndex = 0;
        } else {
            mFirstIndex++;
        }
        mSize--;

        return result;
    }

    public T removeLast() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        T result = mItems[mLastIndex];

        if(mLastIndex == 0) {
            mLastIndex = mItems.length - 1;
        } else {
            mLastIndex--;
        }
        mSize--;

        return result;
    }

    public T peekFirst() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return mItems[mFirstIndex];
    }

    public T peekLast() {
        if(mSize == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return mItems[mLastIndex];
    }

    public int size() {
        return mSize;
    }

    public int getFirstIndex() {
        return mFirstIndex;
    }

    public int getLastIndex() {
        return mLastIndex;
    }

    private void growArray() {
        int newLength = (mSize * 3) / 2 + 1;

//        int newLength = 4;
//        if(mSize > 0) {
//            newLength = mSize * 2;
//        }
        T[] newArray = (T[]) Array.newInstance(Object.class, newLength);

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
