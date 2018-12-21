package com.workout.algorithms.algorithms;

public class BalancedParentheses {
    private int amount;
    private char[] combinations;
    private StringBuilder result = new StringBuilder();
    private int step = 0;
    private int size;

    public BalancedParentheses(int amount) {
        this.amount = amount;
        size = 2 * amount;
        combinations = new char[size];
    }

    public void printAllCombinations() {
        if(amount > 0) {
            generateAllCombinations(0, 0, 0);
            System.out.println(result);
        }
    }

    private void generateAllCombinations(int position, int open, int close) {
        if(close == amount) {
            for(step = 0; step < size; step++) {
                result.append(combinations[step]);
            }
            result.append("\n");
        } else {
            if(open < amount) {
                combinations[position] = '(';
                generateAllCombinations(position + 1, open + 1, close);
            }
            if(open > close) {
                combinations[position] = ')';
                generateAllCombinations(position + 1, open, close + 1);
            }
        }
    }
}
