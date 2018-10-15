package com.workout.algorithms.data_structures.complex_hash_table;

public class Entry<K, V> {
    private K mKey;
    private V mValue;
    private int mHashCode;
    private Entry mNext;

    public Entry(K key, V value, int hashCode, Entry next) {
        mKey = key;
        mValue = value;
        mHashCode = hashCode;
        mNext = next;
    }

    public K key() {
        return mKey;
    }

    public V value() {
        return mValue;
    }

    public int hashCode() {
        return mHashCode;
    }

    public Entry next() {
        return mNext;
    }

    public void setNext(Entry next) {
        mNext = next;
    }
}
