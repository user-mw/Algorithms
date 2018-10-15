package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.complex_hash_table.ComplexHashTable;

public class RunningClass {
    public static void main(String[] args) {
        ComplexHashTable<String, Integer> testingHashTable = new ComplexHashTable<>();

        testingHashTable.add("One", 1);
        testingHashTable.add("Two", 2);
        testingHashTable.add("Three", 3);
        testingHashTable.add("Four", 4);
        testingHashTable.add("Four", 4111);

        testingHashTable.showHashTable();
        System.out.println(testingHashTable.size());
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
