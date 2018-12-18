package com.workout.algorithms.data_structures.doubly_linked_list;

import android.support.annotation.NonNull;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int mSize;
    private DoublyLinkedListNode<T> mFirstElement;
    private DoublyLinkedListNode<T> mLastElement;

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<>(item);

        if(mSize == 0) {
            mLastElement = newElement;
        } else {
            mFirstElement.setPrevious(newElement);
            newElement.setNext(mFirstElement);
        }
        mFirstElement = newElement;
        mSize++;
    }

    public void addLast(T item) {
        DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<>(item);

        if(mSize == 0) {
            mFirstElement = newElement;
        } else {
            mLastElement.setNext(newElement);
            newElement.setPrevious(mLastElement);
        }
        mLastElement = newElement;
        mSize++;
    }

    public boolean addAfter(T value, T item) {
        if(mSize == 0) {
            return false;
        }

        DoublyLinkedListNode<T> current = mFirstElement;

        while(!current.value().equals(value)) {
            current = current.getNext();

            if(current == null) {
                return false;
            }
        }

        DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<>(item);

        if(current.equals(mLastElement)) {
            mLastElement.setNext(newElement);
            newElement.setPrevious(mLastElement);
            mLastElement = newElement;
        } else {
            newElement.setNext(current.getNext());
            current.getNext().setPrevious(newElement);
        }

        newElement.setPrevious(current);
        current.setNext(newElement);
        mSize++;
        return true;
    }

    public void deleteFirst() {
        if(mSize > 0) {
            if(mSize == 1) {
                mFirstElement = null;
                mLastElement = null;
            } else {
                mFirstElement = mFirstElement.getNext();
                mFirstElement.setPrevious(null);
            }
            mSize--;
        }
    }

    public void deleteLast() {
        if(mSize > 0) {
            if(mSize == 1) {
                mFirstElement = null;
                mLastElement = null;
            } else {
                mLastElement = mLastElement.getPrevious();
                mLastElement.setNext(null);
            }
            mSize--;
        }
    }

    public boolean delete(T itemToDelete) {
        DoublyLinkedListNode<T> current = mFirstElement;
        DoublyLinkedListNode<T> previous = null;

        while(current != null) {
            if(current.value().equals(itemToDelete)) {
                if(previous != null) {
                    previous.setNext(current.getNext());

                    if(current.getNext() == null) {
                        mLastElement = previous;
                    } else {
                        current.getNext().setPrevious(previous);
                    }
                    mSize--;
                } else {
                    deleteFirst();
                }

                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public void clear() {
        mFirstElement = null;
        mLastElement = null;
        mSize = 0;
    }

    public boolean contains(T item) {
        DoublyLinkedListNode<T> current = mFirstElement;

        while(current != null) {
            if(current.value().equals(item)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void copyTo(T[] newArray, int newIndex) {
        DoublyLinkedListNode<T> current = mFirstElement;

        while(current != null) {
            newArray[newIndex] = current.value();
            newIndex++;
            current = current.getNext();
        }
    }

    public int size() {
        return mSize;
    }

    public DoublyLinkedListNode<T> getFirstElement() {
        return mFirstElement;
    }

    public DoublyLinkedListNode<T> getLastElement() {
        return mLastElement;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private DoublyLinkedListNode<T> mCurrent = mFirstElement;

            @Override
            public boolean hasNext() {
                return mCurrent != null;
            }

            @Override
            public T next() {
                T result = mCurrent.value();
                mCurrent = mCurrent.getNext();
                return result;
            }
        };
    }
}
