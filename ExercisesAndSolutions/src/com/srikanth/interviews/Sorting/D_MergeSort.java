package com.srikanth.interviews.Sorting;


// Pick a key from 1 to N-1
// Move the elements to left as long askey is less than element  - MOVE UNTIL RIGHT INSERTION
// move elments eight to left as we move right
// N times logN halves - O(NlogN)

// Divide and Conquer

public class D_MergeSort {


    public static void main(String[] args) {
        int[] arr = {63, 4, 5, 54, 23, 19, 0, 45};
        mergeSort(arr);
        printArr(arr);
    }

    private static void mergeSort(int[] arr) {
        // 2 methods are required. One for sort and one for merging
        // sort require start and end positions
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {

        // Recursion has to stop at some point. The point here is until start reach the end
        if (start < end) {
            // make 2 halves
            int mid = start + (end - start) / 2; // this is to avoid sum overflow problem for int type = (start + end) / 2

            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            // merge the sorted half arrays
            mergeSortedHalves(arr, start, mid, end);
        }
    }

    private static void mergeSortedHalves(int[] arr, int start, int mid, int end) {

        // Need temporary arrays  left and right

        // sizes of arrays
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // copy elements to temp arrays
        int index = start;
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[index++];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[index++];
        }

        // now start adding one by one to arr
        int lIndex = 0, rIndex = 0;
        index = start;

        while (lIndex < leftSize && rIndex < rightSize) {
            if (left[lIndex] <= right[rIndex]) {
                arr[index++] = left[lIndex++];
            } else {
                arr[index++] = right[rIndex++];
            }
        }

        // add remaining from left to arr
        while (lIndex < leftSize) {
            arr[index++] = left[lIndex++];
        }

        // add remaining from right to arr
        while (rIndex < rightSize) {
            arr[index++] = right[rIndex++];
        }
    }


    private static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
