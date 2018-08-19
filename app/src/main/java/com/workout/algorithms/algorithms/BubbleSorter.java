package com.workout.algorithms.algorithms;

public class BubbleSorter<T extends Comparable> {

    public static void performSorting(int[] array) {
        for(int step = array.length - 1; step > 1; step--) {
            for(int inStep = 0; inStep < step; inStep++) {
                if(array[inStep] > array[inStep + 1]) {
                    int temp = array[inStep];
                    array[inStep] = array[inStep + 1];
                    array[inStep + 1] = temp;
                }
            }
        }
    }

    public void performSortingForAll(T[] array) {
        for(int step = array.length - 1; step > 1; step--) {
            for(int inStep = 0; inStep < step; inStep++) {
                int result = array[inStep].compareTo(array[inStep + 1]);
                if(result > 0) {
                    T temp = array[inStep];
                    array[inStep] = array[inStep + 1];
                    array[inStep + 1] = temp;
                }
            }
        }
    }
}
