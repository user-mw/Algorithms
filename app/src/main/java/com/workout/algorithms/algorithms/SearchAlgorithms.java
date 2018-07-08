package com.workout.algorithms.algorithms;

public class SearchAlgorithms<T extends Comparable<T>> {
    public static int linearSearch(Object[] array, Object valueToFind) {
        for(int step = 0; step < array.length; step++) {
            if(array[step].equals(valueToFind)) {
                return step;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int valueToFind) {
        int lowIndex = 0;
        int highIndex = array.length;

        while(lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;

            if(array[middleIndex] < valueToFind) {
                lowIndex = middleIndex + 1;
            } else if(array[middleIndex] > valueToFind) {
                highIndex = middleIndex;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] array, int valueToFind, int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;

            if(array[middleIndex] < valueToFind) {
                return binarySearchRecursive(array, valueToFind, middleIndex + 1, highIndex);
            } else if(array[middleIndex] > valueToFind) {
                return binarySearchRecursive(array, valueToFind, lowIndex, middleIndex);
            } else {
                return middleIndex;
            }
        } else {
            return -1;
        }
    }

    public int binarySearchForAll(T[] array, T valueToFind) {

        int lowIndex = 0;
        int highIndex = array.length;

        while(lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;

            int comparingResult = array[middleIndex].compareTo(valueToFind);
            if(comparingResult < 0) {
                lowIndex = middleIndex + 1;
            } else if(comparingResult > 0) {
                highIndex = middleIndex;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
