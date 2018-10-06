package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.linked_list.LinkedListNode;

public class RunningClass {
    public static void main(String[] args) {
        LinkedListNode<Integer> testNode = new LinkedListNode<>(1);

        testNode.setNext(new LinkedListNode<Integer>(2));
        testNode.getNext().setNext(new LinkedListNode<Integer>(3));
        testNode.getNext().getNext().setNext(new LinkedListNode<Integer>(4));
        testNode.getNext().getNext().getNext().setNext(new LinkedListNode<Integer>(5));

        LinkedListNode<Integer> newCurrent = SomeSimpleAlgorithms.reverseLinkedList(testNode);

        while(newCurrent != null) {
            System.out.println(newCurrent.getValue());
            newCurrent = newCurrent.getNext();
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
