package com.workout.algorithms.algorithms;

public class QuickSorter<T extends Comparable> {
    private long[] mUsingArray;
    private T[] mGenericArray;

    public QuickSorter(T[] newArray) {
        mGenericArray = newArray;
    }

    public void performSortingForAll(int left, int right) {
        if(right - left <= 0) {
            return;
        } else {
            T pivot = mGenericArray[right];

            int partition = partitionItForAll(left, right, pivot);
            performSortingForAll(left, partition - 1);
            performSortingForAll(partition + 1, right);
        }
    }

    private int partitionItForAll(int left, int right, T pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while(true) {
            while(mGenericArray[leftPtr].compareTo(pivot) < 0) {
                leftPtr++;
            }
            while(rightPtr > 0 && mGenericArray[rightPtr].compareTo(pivot) > 0) {
                rightPtr--;
            }

            if(leftPtr >= rightPtr) {
                break;
            } else {
                swapForAll(leftPtr, rightPtr);
            }
        }

        swapForAll(leftPtr, right);
        return leftPtr;
    }

    private void swapForAll(int firstIndex, int secondIndex) {
        T temp = mGenericArray[firstIndex];
        mGenericArray[firstIndex] = mGenericArray[secondIndex];
        mGenericArray[secondIndex] = temp;
    }

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

    private void swap(int firstIndex, int secondIndex) {
        long temp = mUsingArray[firstIndex];
        mUsingArray[firstIndex] = mUsingArray[secondIndex];
        mUsingArray[secondIndex] = temp;
    }
}
