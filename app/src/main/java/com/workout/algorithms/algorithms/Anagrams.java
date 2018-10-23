package com.workout.algorithms.algorithms;

public class Anagrams {
    private char[] mLetters;
    private int mSize;

    public Anagrams(String input) {
        mLetters = input.toCharArray();
        mSize = mLetters.length;
    }

    public void createAnagram() {
        createAnagram(mLetters.length);
    }

    public void createAnagram(int newSize) {
        if(newSize == 1) {
            return;
        } else {
            for(int step = 0; step < newSize; step++) {
                createAnagram(newSize - 1);
                if(newSize == 2) {
                    System.out.println(mLetters);
                }
                rotate(newSize);
            }
        }
    }

    private void rotate(int size) {
        int step;
        int position = mSize - size;
        char temp = mLetters[position];

        for(step = position + 1; step < mSize; step++) {
            mLetters[step - 1] = mLetters[step];
        }
        mLetters[step - 1] = temp;
    }
}
