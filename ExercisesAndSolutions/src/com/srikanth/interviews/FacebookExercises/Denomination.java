package com.srikanth.interviews.FacebookExercises;

import java.util.Arrays;
// Add any extra import statements you may need here


public class Denomination {


    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        int max = targetMoney + 1;
        int[] moneyTrack = new int[max];
        Arrays.fill(moneyTrack, max);
        moneyTrack[0] = 0;


        for (int amount = 1; amount <= targetMoney; amount++) {

            for (int denomination : denominations) {
                if (denomination <= amount) {
                    moneyTrack[amount] = Math.min(moneyTrack[amount], moneyTrack[amount - denomination] + 1);
                }
            }
        }
        return moneyTrack[targetMoney] > targetMoney ? false : true;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(StringManipulations str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Denomination().run();
    }
}
