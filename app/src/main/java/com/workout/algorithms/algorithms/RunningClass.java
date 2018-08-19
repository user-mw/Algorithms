package com.workout.algorithms.algorithms;

public class RunningClass {
    public static void main(String[] args) {
        //System.out.println(showBetween(5));
        //SomeSimpleAlgorithms.showBetween(5);
        //System.out.println(SomeSimpleAlgorithms.testFactorial(4));
        //int[] testingArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        System.out.println(SearchAlgorithms.binarySearch(
//                testingArray,
//                15));
//
//        System.out.println(SearchAlgorithms.binarySearchRecursive(
//                testingArray,
//                15, 0, testingArray.length));

//        SearchAlgorithms<Integer> testing = new SearchAlgorithms<>();
//        Integer[] testingStringArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//
//        System.out.println(testing.binarySearchForAll(testingStringArray, 6));

//        int[] someThing = new int[] {10, 1, 8, 6, 5, 7, 9, 4, 2, 3};
//
//        SelectionSorting.performSorting(someThing);
//
//        for(int step = 0; step < someThing.length; step++) {
//            System.out.println(someThing[step]);
//        }

//        String[] testingStringArray = new String[] {"B", "C", "J", "D", "G", "H", "F", "I", "E", "K", "O", "M", "L", "N", "A"};
//
//        SelectionSorting<String> sorter = new SelectionSorting<>();
//
//        sorter.performSortingForAll(testingStringArray);
//
//        for(int step = 0; step < testingStringArray.length; step++) {
//            System.out.println(testingStringArray[step]);
//        }

//        int[] array = new int[] {6, 4, 3, 2, 5, 7, 1, 10, 12, 11, 8, 9, 15, 14, 13, 16};
//
//        InsertionSorter.performSorting(array);
//
//        for(int step = 0; step < array.length; step++) {
//            System.out.println(array[step]);
//        }
//        String[] testingStringArray = new String[] {"B", "C", "J", "D", "G", "H", "F", "I", "E", "K", "O", "M", "L", "N", "A"};
//
//        InsertionSorter<String> sorter = new InsertionSorter<>();
//
//        sorter.performSortingForAll(testingStringArray);
//
//        for(int step = 0; step < testingStringArray.length; step++) {
//            System.out.println(testingStringArray[step]);
//        }

//        long[] testingIntArray = new long[] {7, 3, 4, 5, 1, 10, 2, 8, 6, 9, 0, 12, 15, 13, 16, 11, 14};
//
//        MergeSorter.performSorting(testingIntArray, 0, testingIntArray.length - 1);
//
//        String result = "";
//        for(int step = 0; step < testingIntArray.length; step++) {
//            result += testingIntArray[step] + " ";
//        }

//        String[] testingStringArray = new String[] {"B", "L", "C", "G", "K", "N", "J", "D", "E", "H", "I", "O", "Q", "R", "M", "A", "F", "P"};
//        String[] checkingArray = new String[testingStringArray.length];
//
//        MergeSorter<String> sorter = new MergeSorter<>();
//        sorter.performSortingForAll(testingStringArray, checkingArray, 0, testingStringArray.length - 1);

//        int[] testingArray = new int[] {7, 3, 4, 5, 1, 10, 2, 8, 6, 9, 0, 12, 15, 13, 16, 11, 14};
//        BubbleSorter.performSorting(testingArray);

        String[] testingArray = new String[] {"B", "L", "C", "G", "K", "N", "J", "D", "E", "H", "I", "O", "Q", "R", "M", "A", "F", "P"};
        new BubbleSorter<String>().performSortingForAll(testingArray);

        String result = "";
        for(int step = 0; step < testingArray.length; step++) {
            result += testingArray[step] + " ";
        }

        System.out.println(result);

    }
}
