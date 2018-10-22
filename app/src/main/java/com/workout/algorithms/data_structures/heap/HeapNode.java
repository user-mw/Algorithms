package com.workout.algorithms.data_structures.heap;

import android.support.annotation.NonNull;

public class HeapNode<T extends Comparable<T>> implements Comparable<T> {
    private T mValue;

    public HeapNode(T value) {
        mValue = value;
    }

    public T value() {
        return mValue;
    }

    public void setValue(T value) {
        mValue = value;
    }

    @Override
    public int compareTo(@NonNull T other) {
        return mValue.compareTo(other);
    }
}
