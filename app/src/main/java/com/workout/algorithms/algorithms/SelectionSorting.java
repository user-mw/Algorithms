package com.workout.algorithms.algorithms;

public class SelectionSorting {
    public static void performSorting(int[] array) {
        for(int step = 0; step < array.length - 1; step++) {
            int minIndex = step;

            for(int inStep = step + 1; inStep < array.length; inStep++) {
                if(array[minIndex] > array[inStep]) {
                    minIndex = inStep;
                }
            }

            if(minIndex != step) {
                int temp = array[step];
                array[step] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
