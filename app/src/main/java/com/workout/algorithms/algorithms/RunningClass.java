package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.hash_table.CustomHashTable;

public class RunningClass {
    public static void main(String[] args) {
        CustomHashTable<String> customHashTable = new CustomHashTable<>(8);

        customHashTable.add("One");
        customHashTable.add("Two");
        customHashTable.add("Three");
        customHashTable.add("Four");
        customHashTable.add("Five");
        customHashTable.add("Six");
        customHashTable.add("Seven");
        customHashTable.add("Eight");

        customHashTable.showTable();

        customHashTable.delete("Four");

        System.out.println();

        customHashTable.showTable();

        System.out.println(customHashTable.find("Six") != null);
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
