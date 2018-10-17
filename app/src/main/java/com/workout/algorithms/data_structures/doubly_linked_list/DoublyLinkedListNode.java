package com.workout.algorithms.data_structures.doubly_linked_list;

public class DoublyLinkedListNode<T> {
    private T mValue;
    private DoublyLinkedListNode<T> mNext;
    private DoublyLinkedListNode<T> mPrevious;

    public DoublyLinkedListNode(T value) {
        mValue = value;
    }

    public T value() {
        return mValue;
    }

    public DoublyLinkedListNode<T> getNext() {
        return mNext;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        mNext = next;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return mPrevious;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        mPrevious = previous;
    }
}
