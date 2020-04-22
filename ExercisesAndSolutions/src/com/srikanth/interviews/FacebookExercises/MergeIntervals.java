package com.srikanth.interviews.FacebookExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new MergeIntervals().merge(input);

        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i][0] + "," + result[i][1] + "] ");
        }
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {

        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                } else if (a[0] == b[0]) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });


        // now that they are sorted per first, sort per second
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        int[][] result = merged.toArray(new int[merged.size()][]);

        return result;


    }


}
