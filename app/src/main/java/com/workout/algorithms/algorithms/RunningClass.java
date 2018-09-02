package com.workout.algorithms.algorithms;

public class RunningClass {
    public static void main(String[] args) {
        //System.out.println(SomeSimpleAlgorithms.getFibonacciDigits(0, 1, 144));
        System.out.println(SomeSimpleAlgorithms.getFibonacciDigitsRecursive(0, 1, 1000));
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
