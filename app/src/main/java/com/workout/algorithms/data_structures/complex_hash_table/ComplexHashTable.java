package com.workout.algorithms.data_structures.complex_hash_table;

public class ComplexHashTable<K, V> {
    private EntryLinkedList<K, V>[] mEntries;
    private int mSize;

    public ComplexHashTable() {
        mEntries = new EntryLinkedList[16];

        for(int step = 0; step < mEntries.length; step++) {
            mEntries[step] = new EntryLinkedList<>();
        }
    }

    public V add(K key, V newValue) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, 16);

        V result = null;

        Entry<K, V> current = mEntries[index].find(key, hash);

        if(current == null) {
            addEntry(hash, key, newValue, index);
        } else {
            result = current.value();
            delete(key);
            addEntry(hash, key, newValue, index);
        }
        mSize++;

        return result;
    }

    public V get(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, 16);

        Entry<K, V> current = mEntries[index].find(key, hash);

        if(current == null) {
            return null;
        }

        return current.value();
    }

    public boolean delete(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, 16);

        boolean result = mEntries[index].delete(key, hash);

        if(result) {
            mSize--;
        }

        return result;
    }

    public boolean contains(K key) {
        int hash = hash(key.hashCode());
        int index = indexFor(hash, 16);

        return mEntries[index].find(key, hash) != null;
    }

    private int hash(int keyHash) {
        keyHash ^= (keyHash >>> 20) ^ (keyHash >>> 12);
        return keyHash ^ (keyHash >>> 7) ^ (keyHash >>> 4);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> current = mEntries[index].find(key, hash);
        mEntries[index].add(key, value, hash, current);
    }

    public int size() {
        return mSize;
    }

    public void showHashTable() {
        for(int step = 0; step < mEntries.length; step++) {
            if(mEntries[step].getSize() > 0) {
                mEntries[step].show();
                System.out.println();
            }
        }
    }
}
