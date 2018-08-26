package com.workout.algorithms.algorithms;

public class RunningClass {
    public static void main(String[] args) {
        String[] testingArray = new String[] {"B", "L", "C", "G", "K", "N", "J", "D", "E", "H", "I", "O", "Q", "R", "M", "A", "F", "P"};
        new BubbleSorter<String>().performSortingForAll(testingArray);

        String result = "";
        for(int step = 0; step < testingArray.length; step++) {
            result += testingArray[step] + " ";
        }

        System.out.println(result);

    }
}
