package com.workout.algorithms.data_structures.linked_list;

public class LinkedListNode<T> {
    private T mValue;
    private LinkedListNode<T> mNext;

    public LinkedListNode(T newValue) {
        mValue = newValue;
    }

    public T getValue() {
        return mValue;
    }

    public LinkedListNode<T> getNext() {
        return mNext;
    }

    public void setNext(LinkedListNode<T> next) {
        mNext = next;
    }
}
