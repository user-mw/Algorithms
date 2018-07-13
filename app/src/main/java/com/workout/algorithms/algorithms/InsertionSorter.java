package com.workout.algorithms.algorithms;

public class InsertionSorter<T extends Comparable> {
    public static void performSorting(int[] array) {
        for(int step = 1; step < array.length; step++) {
            int current = array[step];
            int checkingIndex = step;

            while(checkingIndex > 0 && array[checkingIndex - 1] > current) {
                array[checkingIndex] = array[checkingIndex - 1];
                checkingIndex--;
            }

            array[checkingIndex] = current;
        }
    }

    public void performSortingForAll(T[] array) {
        for(int step = 1; step < array.length; step++) {
            T current = array[step];
            int checkingIndex = step;

            while(checkingIndex > 0 && array[checkingIndex - 1].compareTo(current) > 0) {
                array[checkingIndex] = array[checkingIndex - 1];
                checkingIndex--;
            }

            array[checkingIndex] = current;
        }
    }
}
