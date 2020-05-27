package com.srikanth.interviews.Sorting;


// Pick a key from 1 to N-1
// Move the elements to left as long askey is less than element  - MOVE UNTIL RIGHT INSERTION
// move elments eight to left as we move right
// O(n^2)

// Incremental approach

public class C_InsertionSort {


    public static void main(String[] args) {
        int[] arr = {63, 4, 5, 54, 23, 19, 0, 45};
        insertionSort(arr);
        printArr(arr);

        arr = new int[]{63, 4, 5, 54, 23, 19, 0, 45};
        recursiveInsertionSort(arr, arr.length);
        printArr(arr);
    }

    // Require 2 parameters - we reduce length for every pass for last i elements are sorted
    private static void recursiveInsertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        // Process first n-1 elements.
        recursiveInsertionSort(arr, n - 1);

        // now insert the last element in correct position
        int last = arr[n - 1];
        int j = n - 2; // j is one before i which is last index here

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = last;


    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
