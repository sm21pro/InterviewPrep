package com.srikanth.interviews.Sorting;


// select one, identify min in rest and swap - MIN ELEMENT SWAPS
// Note on inner loop - j starts from adjacent and run until len - 1, because j runs until + 1

// O(n^2)

public class A_SelectionSort {


    public static void main(String[] args) {
        int[] arr = {63, 4, 5, 54, 23, 19, 0, 45};
        selectionSort(arr);
        printArr(arr);

        arr = new int[]{63, 4, 5, 54, 23, 19, 0, 45};
        recursiveSelectionSort(arr, 0);
        printArr(arr);
    }

    // selection sort is applied between a sub array where minimum and swappable element exists
    private static void recursiveSelectionSort(int[] arr, int n) { // starts with 0

    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);

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
