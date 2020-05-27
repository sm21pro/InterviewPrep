package com.srikanth.interviews.Arrays;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
    }


    static class Pair {
        int left, right;

        Pair(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString() {
            return "[" + this.left + "," + this.right + "]";
        }
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Queue<Integer> q = new LinkedList<Integer>();
        return null;
    }
}


