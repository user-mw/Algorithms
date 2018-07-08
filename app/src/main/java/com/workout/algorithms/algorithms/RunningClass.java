package com.workout.algorithms.algorithms;

public class RunningClass {
    public static void main(String[] args) {
        //System.out.println(showBetween(5));
        //SomeSimpleAlgorithms.showBetween(5);
        //System.out.println(SomeSimpleAlgorithms.testFactorial(4));
        int[] testingArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
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

        int[] someThing = new int[] {10, 1, 8, 6, 5, 7, 9, 4, 2, 3};

        SelectionSorting.performSorting(someThing);

        for(int step = 0; step < someThing.length; step++) {
            System.out.println(someThing[step]);
        }
    }
}
