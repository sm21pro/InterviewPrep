package com.srikanth.interviews.FacebookExercises;

import java.util.ArrayList;
// Add any extra import statements you may need here


class MinPermutations { // Min swaps required to sort - uses graph edges count -1 from a cycle approach

    // Add any helper functions you may need here
    static ArrayList<ArrayList<Integer>> graph = null;

    static void addEdge(int m, int n) {
        graph.get(m).add(n);
    }

    static int swapsReq(int[] arr) {
        // traverse until cyce is reached
        boolean[] visited = new boolean[graph.size()];
        // Its always one to one
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean cycleReached = false;
            // get the link
            int link = graph.get(arr[i]).get(0);
            int edges = 1;

            while (!cycleReached) {
                // mark visisted
                visited[arr[i]] = true;

                // if link visited
                if (visited[link]) {
                    cycleReached = true;
                } else {
                    // mark link visited
                    visited[link] = true;
                    // increase edges
                    edges++;
                    // get new link
                    link = graph.get(link).get(0);

                }
            }
            count += edges - 1;
            edges = 0;
        }

        return count;
    }

    int minOperations(int[] arr) {
        // Write your code here
        graph = new ArrayList<>();
        int length = arr.length;

        // initialize the graph;
        graph.add(new ArrayList<Integer>());
        for (int i = 1; i <= length; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < length; i++) {
            // 3 to 2 which is arr[2]
            addEdge(arr[i], arr[arr[i] - 1]);
        }


        return swapsReq(arr);
        // add the edges to the graph


    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MinPermutations().run();
    }
}
