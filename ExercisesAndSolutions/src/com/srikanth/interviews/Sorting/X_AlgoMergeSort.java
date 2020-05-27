package com.srikanth.interviews.Sorting;

import java.util.HashMap;

public class X_AlgoMergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        mergeSort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();

        String[] strs = {"AAAAAAAAA", "gopowerrangergogopowerranger", "ABCAB", "ABAb"};
        for (String str : strs) {
            String repeated = str.replaceAll("(.+?)\\1+", "$1");
            System.out.println(repeated);
        }
    }

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        sort(array);
        return array;
    }

    private static void sort(int[] array) {
        // required 2 funcitons. one to sort halves
        // one to merge
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, 0, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // two sub temp arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftSubArr = new int[leftSize];
        int[] rightSubArr = new int[rightSize];

        // copy elements to sub arrays
        int index = left;

        for (int i = 0; i < leftSize; i++) {
            leftSubArr[i] = array[index++];
        }

        for (int j = 0; j < rightSize; j++) {
            rightSubArr[j] = array[index++];
        }

        // now merge the sub arrays to main array with comparison
        index = left;
        int lIndex = 0, rIndex = 0;
        while (lIndex < leftSize && rIndex < rightSize) {
            if (leftSubArr[lIndex] <= rightSubArr[rIndex]) {
                array[index++] = leftSubArr[lIndex++];
            } else {
                array[index++] = rightSubArr[rIndex++];
            }
        }

        // copy remaining elements
        while (lIndex < leftSize) {
            array[index++] = leftSubArr[lIndex++];
        }
        while (rIndex < rightSize) {
            array[index++] = rightSubArr[rIndex++];
        }
    }
}
