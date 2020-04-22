package com.srikanth.interviews.FacebookExercises;

// Add any extra import statements you may need here
/*
Revenue Milestones
We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array containing the days on which Facebook reached every milestone.
Signature
int[] getMilestoneDays(int[] revenues, int[] milestones)
Input
revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is a length-K array of interesting total revenue milestones.
Output
Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
Example
revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
milestones = [100, 200, 500]
output = [4, 6, 10]
Explanation
On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that FB has >= $200 of total revenue.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class MilestonesBF {

    // Add any helper functions you may need here



    int[] getMilestoneDays(int[] revenues, int[] milestones) {

        TreeMap<Integer, Integer> mMap = new TreeMap<>();
        for (int mile : milestones) {
            mMap.put(mile, 0);
        }

        Set<Integer> mileStones = mMap.keySet();

        Iterator<Integer> miletor = mileStones.iterator();
        int nextMileStone = miletor.next();
        int revLength = revenues.length;

        int revenueSoFar = 0;

        for (int i = 0; i < revLength; i++) {

            revenueSoFar += revenues[i];

            while (revenueSoFar >= nextMileStone) {
                int val = mMap.get(nextMileStone);
                if (val == 0) {
                    mMap.put(nextMileStone, i + 1);
                }
                if (miletor.hasNext()) {
                    nextMileStone = miletor.next();
                } else {
                    break;
                }
            }
        }

        int[] array = new int[milestones.length];
        for (int i = 0; i < milestones.length; i++) {
            array[i] = mMap.get(milestones[i]);
        }

        System.out.println((int)Math.pow(1.5, 51));

        return array;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        check(expected_1, output_1);

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MilestonesBF().run();
    }
}
