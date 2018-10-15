package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.complex_hash_table.ComplexHashTable;

public class RunningClass {
    public static void main(String[] args) {
        ComplexHashTable<String, Integer> testing = new ComplexHashTable<>();

        testing.add("One", 1);
        testing.add("Two", 2);
        testing.add("Three", 3);
        testing.add("Four", 4);
        testing.add("Five", 5);

        System.out.println(testing.contains("One"));
        System.out.println(testing.contains("Two"));
        System.out.println(testing.contains("Three"));
        System.out.println(testing.contains("Onwere"));
        System.out.println(testing.contains("Four"));
        System.out.println(testing.contains("Five"));

        testing.delete("Five");
        testing.delete("One");
        testing.delete("Three");
        testing.delete("Four");
        testing.delete("Two");

        System.out.printf("Size is %s \n", testing.size());

        testing.showHashTable();

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
