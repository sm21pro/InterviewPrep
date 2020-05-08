package com.srikanth.interviews.Hybrid;

import java.util.Scanner;

// Problem : https://www.hackerrank.com/challenges/java-loops/problem

class FormulaSeries {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSeries(a, b, n);
        }
        in.close();
    }

    private static void printSeries(int a, int b, int n) {

        // result series will be n numbers
        int[] result = new int[n];

        // populate n numbers to result array - meaning n iterations

        // calculate result[0] which is first in series
        // Math.pow returns double, Casting to int
        result[0] = a + (int) Math.pow(2, 0) * b;  // this is a + 2^0 * b --> X

        // result[0] already populated. Start from 1
        for (int i = 1; i < n; i++) {
            // Previous value plus current value with formula
            int sum = result[i - 1] + (int) Math.pow(2, i) * b; // this is X + (2^1 * b)
            result[i] = sum;
        }

        // print result
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]); // not println

            // add a space if not reached end
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        // new line at the end of series
        System.out.println();
    }
}
