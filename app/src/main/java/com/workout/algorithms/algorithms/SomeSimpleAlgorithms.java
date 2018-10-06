package com.workout.algorithms.algorithms;

public class SomeSimpleAlgorithms {
    public static int testSimpleFactorial(int digit) {
        int result = 1;

        for(int step = 1; step <= digit; step++) {
            result *= step;
        }

        return result;
    }

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

    public static String getFibonacciDigits(long firstDigit, long secondDigit, long limit) {
        String result = firstDigit + " " + secondDigit + " ";

        while(secondDigit < limit) {
            long firstDigitCopy = firstDigit;
            firstDigit = secondDigit;
            secondDigit += firstDigitCopy;
            result += secondDigit + " ";
        }

        return result;
    }

    public static String getFibonacciDigitsRecursive(long firstDigit, long secondDigit, long limit) {
        if(secondDigit >= limit) {
            return secondDigit + "";
        }

        if(firstDigit == 0) {
            return firstDigit + " " + secondDigit + " " + getFibonacciDigitsRecursive(secondDigit, secondDigit + firstDigit, limit);
        }

        return secondDigit + " " + getFibonacciDigitsRecursive(secondDigit, secondDigit + firstDigit, limit);
    }

    public static String reverseString(String input) {
        String result = "";

        char[] letters = input.toCharArray();

        for(int step = letters.length - 1; step >= 0; step--) {
            result += letters[step];
        }

        return result;
    }
}
