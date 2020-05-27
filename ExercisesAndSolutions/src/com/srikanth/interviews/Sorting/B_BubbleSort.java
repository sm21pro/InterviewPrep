package com.srikanth.interviews.Sorting;


// Bubble big and take it all the way to end until sorted - ADJACENT SWAPS
// Note on inner loop - it starts from 0 and runs only until uncovered items in previous iterations. which is length - 1 - i
// selection from left to right, bubble from right to left

// O(n^2)

public class B_BubbleSort {


    public static void main(String[] args) {
        int[] arr = {63, 4, 5, 54, 23, 19, 0, 45};
        bubbleSort(arr);
        printArr(arr);

        arr = new int[]{63, 4, 5, 54, 23, 19, 0, 45};
        recursiveBubbleSort(arr, arr.length);
        printArr(arr);
    }

    // Require 2 parameters - we reduce length for every pass for last i elements are sorted
    private static void recursiveBubbleSort(int[] arr, int n) {

        // base case
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        recursiveBubbleSort(arr, n - 1);
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
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
