package com.workout.algorithms.data_structures.linked_list;

public class CustomLinkedList<T> {

    private int mSize;
    private LinkedListNode<T> mFirstElement;
    private LinkedListNode<T> mLastElement;

    public void add(T item) {
        LinkedListNode<T> newElement = new LinkedListNode<>(item);

        if(mSize == 0) {
            mFirstElement = newElement;
        } else {
            mLastElement.setNext(newElement);
        }
        mLastElement = newElement;
        mSize++;
    }

    public void addCanonical(T item) {
        LinkedListNode<T> newElement = new LinkedListNode<>(item);

        if(mSize == 0) {
            mLastElement = newElement;
        } else {
            newElement.setNext(mFirstElement);
        }
        mFirstElement = newElement;
        mSize++;
    }

    public boolean delete(T itemToDelete) {
        LinkedListNode<T> current = mFirstElement;
        LinkedListNode<T> previous = null;

        while(current != null) {
            if(current.getValue().equals(itemToDelete)) {
                if(previous != null) {
                    previous.setNext(current.getNext());

                    if(current.getNext() == null) {
                        mLastElement = previous;
                    }
                } else {
                    mFirstElement = mFirstElement.getNext();

                    if(mFirstElement == null) {
                        mLastElement = null;
                    }
                }

                mSize--;
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public boolean contains(T item) {
        LinkedListNode<T> current = mFirstElement;

        while(current != null) {
            if(current.getValue().equals(item)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void showList() {
        LinkedListNode<T> current = mFirstElement;

        while(current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    public void copyTo(T[] newArray, int newIndex) {
        LinkedListNode<T> current = mFirstElement;

        while(current != null) {
            newArray[newIndex] = current.getValue();
            newIndex++;
            current = current.getNext();
        }
    }

    public int getSize() {
        return mSize;
    }

    public LinkedListNode<T> getFirstElement() {
        return mFirstElement;
    }
}
