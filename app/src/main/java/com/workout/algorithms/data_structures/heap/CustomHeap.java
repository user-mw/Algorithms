package com.workout.algorithms.data_structures.heap;

import android.support.annotation.NonNull;

import java.util.Iterator;

public class CustomHeap<T extends Comparable<T>> implements Iterable<T> {

    private HeapNode<T>[] mItems;
    private int mMaxSize;
    private int mSize;

    public CustomHeap(int maxSize) {
        if(maxSize < 0) {
            throw new IllegalArgumentException("Max size can not be less than zero");
        }

        mItems = new HeapNode[maxSize];
        mMaxSize = maxSize;
        mSize = 0;
    }

    public boolean insert(T item) {
        if(mSize == mMaxSize) {
            return false;
        }

        HeapNode<T> node = new HeapNode<>(item);
        mItems[mSize] = node;
        trickleUp(mSize);
        mSize++;
        return true;
    }

    public HeapNode<T> delete() {
        if(mSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        HeapNode<T> node = mItems[0];
        mSize--;
        mItems[0] = mItems[mSize];
        trickleDown(0);
        return node;
    }

    public boolean change(int index, T newValue) {
        if(index < 0 || index >= mSize) {
            return false;
        }

        T oldValue = mItems[index].value();
        mItems[index].setValue(newValue);

        if(oldValue.compareTo(newValue) < 0) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap()
    {
        System.out.print("heapArray: ");
        for(int m = 0; m < mSize; m++) {
            if(mItems[m] != null) {
                System.out.print(mItems[m].value() + " ");
            }
            else {
                System.out.print("-- ");
            }
        }

        System.out.println();
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots+dots);
        while(mSize > 0)
        {
            if(column == 0) {
                for(int k=0; k<nBlanks; k++) {
                    System.out.print(" ");
                }
            }

            System.out.print(mItems[j].value());
            if(++j == mSize) {
                break;
            }
            if(++column==itemsPerRow)
            {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else {
                for(int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public T peek() {
        return mItems[0].value();
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
                T result = mItems[mStep].value();
                mStep++;
                return result;
            }
        };
    }

    public int size() {
        return mSize;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        HeapNode<T> bottom = mItems[index];

        while(index > 0 && mItems[parent].compareTo(bottom.value()) < 0) {
            mItems[index] = mItems[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        mItems[index] = bottom;
    }

    private void trickleDown(int index) {
        int largerChild;
        HeapNode<T> top = mItems[index];

        while(index < mSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if(rightChild < mSize && mItems[leftChild].compareTo(mItems[rightChild].value()) < 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if(top.compareTo(mItems[largerChild].value()) >= 0) {
                break;
            }

            mItems[index] = mItems[largerChild];
            index = largerChild;
        }
        mItems[index] = top;
    }
}
