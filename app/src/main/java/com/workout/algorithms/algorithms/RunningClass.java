package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.doubly_linked_list.DoublyLinkedList;

public class RunningClass {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> testing = new DoublyLinkedList<>();

        testing.add(1);
        testing.add(2);
        testing.add(3);
        testing.add(4);
        testing.add(5);
        testing.add(6);
        testing.add(7);

        testing.delete(5);
        testing.deleteFirst();
        testing.deleteLast();

        testing.addFirst(0);

        for(Integer value : testing) {
            System.out.printf("%s ", value);
        }

        System.out.printf("\nSize is %s \n", testing.size());

        testing.clear();

        System.out.printf("Size is %s \n", testing.size());
        System.out.println(testing.getFirstElement());
        System.out.println(testing.getLastElement());

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
