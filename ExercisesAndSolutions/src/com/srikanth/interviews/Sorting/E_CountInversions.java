package com.srikanth.interviews.Sorting;

/*
Inversion Count for an array indicates – how far (or close) the array is from being sorted.
If array is already sorted then inversion count is 0.
If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:

        Input: arr[] = {8, 4, 2, 1}
        Output: 6

        Explanation: Given array has six inversions:
        (8,4), (4,2),(8,2), (8,1), (4,1), (2,1).


        Input: arr[] = {3, 1, 2}
        Output: 2

        Explanation: Given array has two inversions:
        (3, 1), (3, 2)
*/

public class E_CountInversions {


    public static void main(String[] args) {
        int[] arr = {63, 4, 5, 54, 23, 19, 0, 45};

        // sort using merge sort
        System.out.println(countInversions(arr));

        arr = new int[]{1, 20, 6, 4, 5};
        System.out.println(countInversions(arr));

    }

    private static int countInversions(int[] arr) {
        // call sort util method
        return mergeSortUtil(arr, 0, arr.length - 1);
    }

    private static int mergeSortUtil(int[] arr, int start, int end) {
        // sort 2 halves and merge
        int inversions = 0;
        if (start < end) {

            int mid = start + (end - start) / 2;

            inversions += mergeSortUtil(arr, start, mid);
            inversions += mergeSortUtil(arr, mid + 1, end);

            inversions += mergeHalves(arr, start, mid, end);
        }
        return inversions;
    }

    private static int mergeHalves(int[] arr, int start, int mid, int end) {

        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // fill arrays
        int index = start;

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[index++];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[index++];
        }

        int lIndex = 0, rIndex = 0, inversion = 0;
        index = start;
        while (lIndex < leftSize && rIndex < rightSize) {
            if (left[lIndex] <= right[rIndex]) {
                arr[index++] = left[lIndex++];
            } else {
                arr[index++] = right[rIndex++];
                // size of left subarray minus current index
                inversion += (mid + 1) - (start + lIndex); // remaining elements in left sub array
            }
        }

        // add rest
        while (lIndex < leftSize) {
            arr[index++] = left[lIndex++];
        }
        while (rIndex < rightSize) {
            arr[index++] = right[rIndex++];
        }

        return inversion;
    }


    private static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
