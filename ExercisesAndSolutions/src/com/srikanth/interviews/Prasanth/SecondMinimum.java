package com.srikanth.interviews.Prasanth;

/*
You are given an array of integers. Complete the method that returns the second minimum element in the array
Ex: [1,4,6,3,2,18,3]
Output: 2
1 is first minimum
2 is second minimum
 */

public class SecondMinimum {
    public static void main(String[] args) {
        int[] a = {1, 4, 6, 3, 2, 18, 3};
        int expected = 2;
        System.out.println(expected == getSecondMinimum(a));
        a = new int[]{11, 14, 634, 300000000, -2, -18, 13};
        expected = -2;
        System.out.println(expected == getSecondMinimum(a));
        a = new int[]{16464466, 8432532, 498635935, 932653, 53452, 4518, 3};
        expected = 4518;
        System.out.println(expected == getSecondMinimum(a));
    }


    private static int getSecondMinimum(int[] array) {

        // Your code here
        return 0;
    }
}
