package com.workout.algorithms.data_structures.complex_hash_table;

public class Entry<K, V> {
    private K mKey;
    private V mValue;
    private int mHashCode;
    private Entry<K, V> mNext;

    public Entry(K key, V value, int hashCode, Entry<K, V> next) {
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

    public Entry<K, V> next() {
        return mNext;
    }

    public void setNext(Entry<K, V> next) {
        mNext = next;
    }
}
