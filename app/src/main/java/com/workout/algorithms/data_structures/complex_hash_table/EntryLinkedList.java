package com.workout.algorithms.data_structures.complex_hash_table;

public class EntryLinkedList<K, V> {
    private Entry<K, V> mFirstElement;
    private int mSize;

    public void add(K key, V value, int hash, Entry next) {
        Entry<K, V> newItem = new Entry<>(key, value, hash, next);

        if(mSize == 0) {
            mFirstElement = newItem;
        } else {
            newItem.setNext(mFirstElement);
        }
        mFirstElement = newItem;
        mSize++;
    }

    public boolean delete(K key, int hash) {
        Entry<K, V> current = mFirstElement;
        Entry<K, V> previous = null;

        while(current != null) {
            if(current.hashCode() == hash && (current.key() == key || current.key().equals(key))) {
                if(previous != null) {
                    previous.setNext(current.next());
                } else {
                    mFirstElement = mFirstElement.next();
                }

                mSize--;
                return true;
            }

            previous = current;
            current = current.next();
        }

        return false;
    }

    public Entry<K, V> find(K key, int hash) {
        Entry<K, V> current = mFirstElement;

        while(current != null) {
            if(current.hashCode() == hash && (current.key() == key || current.key().equals(key))) {
                return current;
            }
            current = current.next();
        }

        return null;
    }

    public void show() {
        Entry<K, V> current = mFirstElement;

        while(current != null) {
            System.out.print(current.value() + " ");
            current = current.next();
        }
    }

    public int getSize() {
        return mSize;
    }
}
