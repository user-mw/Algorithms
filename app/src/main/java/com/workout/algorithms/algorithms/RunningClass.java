package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.array_list.CustomArrayList;

public class RunningClass {
    public static void main(String[] args) {
        CustomArrayList<String> testArrayList = new CustomArrayList<>();

        testArrayList.add("One");
        testArrayList.add("Five");
        testArrayList.add("Three");
        testArrayList.add("Four");
        testArrayList.deleteAt(1);

        testArrayList.insert(1, "Two");

        System.out.println(testArrayList.size());
        System.out.printf("Index of Two is %s\n", testArrayList.indexOf("Two"));

        for(String value : testArrayList) {
            System.out.print(value + " ");
        }
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
