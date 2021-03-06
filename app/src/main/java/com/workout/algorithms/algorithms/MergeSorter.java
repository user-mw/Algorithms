package com.workout.algorithms.algorithms;

public class MergeSorter<T extends Comparable> {

    public void performSortingForAll(T[] array, T[] checkingArray, int lowIndex, int highIndex) {
        if(lowIndex == highIndex) {
            return;
        } else {
            int middleIndex = (lowIndex + highIndex) / 2;

            performSortingForAll(array, checkingArray, middleIndex + 1, highIndex);
            performSortingForAll(array, checkingArray, lowIndex, middleIndex);
            mergeForAll(array, checkingArray, lowIndex, middleIndex + 1, highIndex);
        }
    }

    private void mergeForAll(T[] original, T[] checkingArray, int lowPtr,
                             int highPtr, int highIndex) {
        int workIndex = 0;
        int lowIndex = lowPtr;
        int middleIndex = highPtr - 1;
        int amount = highIndex - lowIndex + 1;

        while(lowPtr <= middleIndex && highPtr <= highIndex) {
            if(original[lowPtr].compareTo(original[highPtr]) < 0) {
                checkingArray[workIndex] = original[lowPtr];
                workIndex++;
                lowPtr++;
            } else {
                checkingArray[workIndex] = original[highPtr];
                workIndex++;
                highPtr++;
            }
        }

        while(lowPtr <= middleIndex) {
            checkingArray[workIndex] = original[lowPtr];
            workIndex++;
            lowPtr++;
        }

        while(highPtr <= highIndex) {
            checkingArray[workIndex] = original[highPtr];
            workIndex++;
            highPtr++;
        }

        for(workIndex = 0; workIndex < amount; workIndex++) {
            original[lowIndex + workIndex] = checkingArray[workIndex];
        }
    }

    public static void performSorting(long[] array, int lowIndex, int highIndex) {
        if(lowIndex == highIndex) {
            return;
        } else {
            long[] checkingArray = new long[array.length];

            int middleIndex = (lowIndex + highIndex) / 2;

            performSorting(array, middleIndex + 1, highIndex);
            performSorting(array, lowIndex, middleIndex);
            merge(array, checkingArray, lowIndex, middleIndex + 1, highIndex);
        }
    }

    private static void merge(long[] original, long[] checkingArray, int lowPtr,
                              int highPtr, int highIndex) {
        int workIndex = 0;
        int lowIndex = lowPtr;
        int middleIndex = highPtr - 1;
        int amount = highIndex - lowIndex + 1;

        while(lowPtr <= middleIndex && highPtr <= highIndex) {
            if(original[lowPtr] < original[highPtr]) {
                checkingArray[workIndex] = original[lowPtr];
                workIndex++;
                lowPtr++;
            } else {
                checkingArray[workIndex] = original[highPtr];
                workIndex++;
                highPtr++;
            }
        }

        while(lowPtr <= middleIndex) {
            checkingArray[workIndex] = original[lowPtr];
            workIndex++;
            lowPtr++;
        }

        while(highPtr <= highIndex) {
            checkingArray[workIndex] = original[highPtr];
            workIndex++;
            highPtr++;
        }

        for(workIndex = 0; workIndex < amount; workIndex++) {
            original[lowIndex + workIndex] = checkingArray[workIndex];
        }
    }
}
