package com.workout.algorithms.data_structures;

import android.support.annotation.NonNull;

public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<T> {

    private T mValue;
    private BinaryTreeNode<T> mLeft;
    private BinaryTreeNode<T> mRight;

    public BinaryTreeNode(T value) {
        mValue = value;
    }

    @Override
    public int compareTo(@NonNull T other) {
        return mValue.compareTo(other);
    }

    public T getValue() {
        return mValue;
    }

    public BinaryTreeNode<T> getLeft() {
        return mLeft;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        mLeft = left;
    }

    public BinaryTreeNode<T> getRight() {
        return mRight;
    }

    public void setRight(BinaryTreeNode<T> right) {
        mRight = right;
    }
}
