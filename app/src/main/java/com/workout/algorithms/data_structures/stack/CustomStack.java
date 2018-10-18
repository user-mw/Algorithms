package com.workout.algorithms.data_structures.stack;

import android.support.annotation.NonNull;

import com.workout.algorithms.data_structures.doubly_linked_list.DoublyLinkedList;
import com.workout.algorithms.data_structures.doubly_linked_list.DoublyLinkedListNode;

import java.util.EmptyStackException;
import java.util.Iterator;

public class CustomStack<T> implements Iterable<T> {
    private DoublyLinkedList<T> mItems = new DoublyLinkedList<>();
    private int mSize;

    public void push(T item) {
        mItems.addLast(item);
        mSize++;
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T result = mItems.getLastElement().value();
        mItems.deleteLast();
        mSize--;
        return result;
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return mItems.getLastElement().value();
    }

    public int search(T item) {
        DoublyLinkedListNode<T> current = mItems.getLastElement();
        int index = 1;

        while(current != null) {
            if(current.value().equals(item)) {
                return index;
            }
            current = current.getPrevious();
            index++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return mSize == 0;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return mItems.iterator();
    }

    public int size() {
        return mSize;
    }
}
