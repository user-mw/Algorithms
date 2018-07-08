package com.workout.algorithms.algorithms;

public class SomeSimpleAlgorithms {
    public static int testFactorial(int digit) {
        if(digit == 1) {
            return 1;
        }

        return testFactorial(digit - 1) * digit;
    }

    public static String showBetween(int digit) {
        if(digit == 2) {
            return "";
        }

        String result = showBetween(digit - 1) + " " + (digit - 1);

        System.out.println(result);
        return result;
    }
}
