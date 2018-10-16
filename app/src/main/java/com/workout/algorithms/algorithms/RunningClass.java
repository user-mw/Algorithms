package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.array_list.CustomArrayList;
import com.workout.algorithms.data_structures.queue.ArrayQueue;

public class RunningClass {
    public static void main(String[] args) {
        ArrayQueue<Integer> testQueue = new ArrayQueue<>();

        testQueue.add(1);
        testQueue.add(2);
        testQueue.add(3);
        testQueue.add(4);
        testQueue.add(5);
        testQueue.add(6);
        testQueue.add(7);
        testQueue.add(8);
        testQueue.add(9);
        testQueue.add(10);

        for(Integer value : testQueue) {
            System.out.printf("%s ", value);
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
