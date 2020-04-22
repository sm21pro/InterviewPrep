package com.srikanth.interviews.FacebookExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxOverlaps {

    public static void main(String[] args) {
        int[] entries = new int[]{1, 2, 9, 5, 5};
        int[] exits = new int[]{4, 5, 12, 9, 12};

        printHourOfMaxPeople(entries, exits);
    }

    private static void printHourOfMaxPeople(int[] entries, int[] exits) {

        int length = entries.length;

        int lateEntry = Arrays.stream(entries).max().getAsInt();
        int lateExit = Arrays.stream(exits).max().getAsInt();

        int maxTime = Math.max(lateEntry, lateExit);

        // Auxilary array to track counts
        int[] times = new int[maxTime + 2];

        // lazy loading. People at certain time
        for (int i = 0; i < length; i++) {
            times[entries[i]]++;
            times[exits[i] + 1]--;
        }

        int current = 0, time = 0;
        int hourOfMax = Integer.MIN_VALUE;

        // lazily calculate max value at time
        for (int i = 0; i <= maxTime; i++) {
            current += times[i]; // current people at the time

            if (hourOfMax < current) {
                hourOfMax = current;
                time = i;
            }
        }

        System.out.println(time);
    }
}
