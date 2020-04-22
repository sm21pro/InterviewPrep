package com.srikanth.interviews.FacebookExercises;

import java.util.Arrays;

public class Main {

    public static void main(StringManipulations[] args) {
        int sum = 2 + 3;
        System.out.println(Integer.toString(sum).length());
    }

    int getTotalTime(int[] arr) {
        // Write your code here
        int penalty = 0;
        int length = arr.length;
        if(length == 1) {
            return penalty;
        }

        Arrays.sort(arr);

        int previous = arr[0];
        for(int i=1; i< length; i++) {
            penalty += previous + arr[i];
            previous += arr[i];
        }


        return penalty;
    }
}
