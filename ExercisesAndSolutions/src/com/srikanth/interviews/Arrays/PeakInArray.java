package com.srikanth.interviews.Arrays;

public class PeakInArray {

    public static void main(String[] array) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

    public static int longestPeak(int[] array) {

        if (array == null || array.length <= 2) {
            return 0;
        }

        // start by treating every element as tip of peak.
        int i = 1;
        int longestPeakLength = 0;

        // 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3
        //                                     i
        //                                  r

        // iterate until end-1 index
        while (i < array.length - 1) {
            // if not peak, continue
            if (!(array[i - 1] < array[i] && array[i] < array[i + 1])) {
                i++;
                continue;
            }

            // if peak calculate length
            int currentLength = 1; // 6
            int left = i;
            while (left > 0 && array[left - 1] < array[left]) {
                currentLength++;
                left--;
            }
            int right = i;
            while (right < array.length - 1 && array[right + 1] < array[right]) {
                currentLength++;
                right++;
            }
            System.out.println(currentLength);

            if (currentLength > longestPeakLength) {
                longestPeakLength = currentLength;
            }

            i++;
        }


        return longestPeakLength;
    }
}

