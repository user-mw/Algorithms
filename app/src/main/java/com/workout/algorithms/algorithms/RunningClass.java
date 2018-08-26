package com.workout.algorithms.algorithms;

public class RunningClass {
    public static void main(String[] args) {
//        String[] testingArray = new String[] {"B", "L", "C", "G", "K", "N", "J", "D", "E", "H", "I", "O", "Q", "R", "M", "A", "F", "P"};
//        new BubbleSorter<String>().performSortingForAll(testingArray);

        long[] testingArray = new long[] {0, 1, 4, 2, 5, 10, 7, 3, 8, 9, 6, 12, 16, 13, 11, 15, 14};
        QuickSorter sorter = new QuickSorter(testingArray);
        sorter.performSorting(0, testingArray.length - 1);
        showLongArray(testingArray);

    }

    private static void showLongArray(long[] array) {
        String result = "";

        for(int step = 0; step < array.length; step++) {
            result += array[step] + " ";
        }

        System.out.println(result);
    }

    private static void showStringArray(String[] array) {
        String result = "";

        for(int step = 0; step < array.length; step++) {
            result += array[step] + " ";
        }

        System.out.println(result);
    }
}
