package com.workout.algorithms.algorithms;

public class QuickSorter {
    private long[] mUsingArray;

    public QuickSorter(long[] newArray) { // not generic yet
        mUsingArray = newArray;
    }

    public void performSorting(int left, int right) {
        if(right - left <= 0) {
            return;
        } else {
            long pivot = mUsingArray[right];

            int partition = partitionIt(left, right, pivot);
            performSorting(left, partition - 1);
            performSorting(partition + 1, right);
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while(true) {
            while(mUsingArray[leftPtr] < pivot) {
                leftPtr++;
            }
            while(rightPtr > 0 && mUsingArray[rightPtr] > pivot) {
                rightPtr--;
            }

            if(leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int firstElement, int secondElement) {
        long temp = mUsingArray[firstElement];
        mUsingArray[firstElement] = mUsingArray[secondElement];
        mUsingArray[secondElement] = temp;
    }
}
