package com.workout.algorithms.data_structures.hash_table;

import com.workout.algorithms.data_structures.linked_list.CustomLinkedList;
import com.workout.algorithms.data_structures.linked_list.LinkedListNode;

public class CustomHashTable<T> {
    private CustomLinkedList[] mEntries;
    private int mSize;
    private int mElementsAmount;

    public CustomHashTable(int newSize) {
        if(newSize < 0) {
            throw new IllegalArgumentException("Size can not be less than zero");
        }

        mSize = newSize;
        mEntries = new CustomLinkedList[newSize];

        for(int step = 0; step < mSize; step++) {
            mEntries[step] = new CustomLinkedList();
        }
    }

    public void showTable() {
        for(int step = 0; step < mSize; step++) {
            if(mEntries[step].getSize() > 0) {
                mEntries[step].showList();
                System.out.println();
            }
        }
    }

    private int hashFunction(int key) {
        return key % mSize;
    }

    public void add(T item) {
        int hash = hashFunction(item.hashCode());
        mEntries[hash].add(item);
        mElementsAmount++;
    }

    public boolean delete(T key) {
        int hash = hashFunction(key.hashCode());
        boolean isDeleted = mEntries[hash].delete(key);

        if(isDeleted) {
            mElementsAmount--;
        }

        return isDeleted;
    }

    public T find(T key) {
        int hash = hashFunction(key.hashCode());
        return (T)mEntries[hash].find(key);
    }

    public int getSize() {
        return mElementsAmount;
    }
}
