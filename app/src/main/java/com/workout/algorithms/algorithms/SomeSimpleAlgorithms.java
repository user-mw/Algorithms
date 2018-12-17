package com.workout.algorithms.algorithms;

import com.workout.algorithms.data_structures.doubly_linked_list.DoublyLinkedListNode;
import com.workout.algorithms.data_structures.linked_list.LinkedListNode;

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

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> node) {
        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = node;
        LinkedListNode<Integer> next = null;

        while(current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }

    public static boolean definePalindrome(int digit) {
        int fullPart = digit;
        int reverse = 0;

        while(fullPart != 0) {
            reverse *= 10;
            reverse += fullPart % 10;
            fullPart /= 10;
        }

        return reverse == digit;
    }

    public static LinkedListNode<Integer> getChosenReverse(LinkedListNode<Integer> node, int firstIndex, int lastIndex) {
        LinkedListNode<Integer> reverseStart = null;
        LinkedListNode<Integer> reverseEnd = null;
        LinkedListNode<Integer> reverseStartPrevious = null;
        LinkedListNode<Integer> reverseEndNext = null;

        LinkedListNode<Integer> current = node;
        int index = 0;

        while(current != null && index <= lastIndex) {
            if(index < firstIndex) {
                reverseStartPrevious = current;
            }

            if(index == firstIndex) {
                reverseStart = current;
            }

            if(index == lastIndex) {
                reverseEnd = current;
                reverseEndNext = current.getNext();
            }

            current = current.getNext();
            index++;
        }

        reverseEnd.setNext(null);
        reverseEnd = reverseLinkedList(reverseStart);

        if(reverseStartPrevious != null) {
            reverseStartPrevious.setNext(reverseEnd);
        } else {
            node = reverseEnd;
        }

        reverseStart.setNext(reverseEndNext);
        return node;
    }

    public static LinkedListNode<Integer> getSpecialReverseSum(LinkedListNode<Integer> firstDigit, LinkedListNode<Integer> secondDigit) {
        LinkedListNode<Integer> result = null;

        LinkedListNode<Integer> currentOne = firstDigit;
        LinkedListNode<Integer> currentTwo = secondDigit;

        int addition = 0;

        while(currentOne != null) {
            int sum = currentOne.getValue() + currentTwo.getValue() + addition;

            if(sum > 9) {
                sum %= 10;
                addition = 1;
            } else {
                addition = 0;
            }

            LinkedListNode<Integer> newElement = new LinkedListNode<>(sum);
            if(result != null) {
                newElement.setNext(result);
            }
            result = newElement;

            currentOne = currentOne.getNext();
            currentTwo = currentTwo.getNext();
        }

        if(addition != 0) {
            LinkedListNode<Integer> resultCopy = result;
            result = new LinkedListNode<>(1);
            result.setNext(resultCopy);
        }

        return reverseLinkedList(result);
    }

    public static LinkedListNode<Integer> reverseListByGroups(LinkedListNode<Integer> node, int groupsCount) {
        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = node;
        LinkedListNode<Integer> next = null;

        int index = 0;

        while(index < groupsCount && current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            index++;
        }

        if(next != null) {
            node.setNext(reverseListByGroups(next, groupsCount));
        }

        return previous;
    }

    public static DoublyLinkedListNode<Integer> reverseDoublyLinkedList(DoublyLinkedListNode<Integer> node) {
        DoublyLinkedListNode<Integer> temp = null;
        DoublyLinkedListNode<Integer> current = node;

        while(current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }

        if(temp != null) {
            node = temp.getPrevious();
        }

        return node;
    }

    public static DoublyLinkedListNode<Integer> reverseDoublyLinkedListFromEnd(DoublyLinkedListNode<Integer> endNode) {
        DoublyLinkedListNode<Integer> temp = null;
        DoublyLinkedListNode<Integer> current = endNode;

        while(current != null) {
            temp = current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(temp);
            current = current.getNext();
        }

        return endNode;
    }
}
