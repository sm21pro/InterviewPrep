package com.srikanth.interviews.Prasanth;

/*
Complete the program below to print first element of every category

Example Input:
--------------
Enter number categories:
2
Enter Category:
cars
Enter comma separated elements:
scoda,bmw,suzuki
Enter Category:
fruits
Enter comma separated elements:
banana,orange

Output:
-------
cars:scoda
fruits:banana

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapWithList {


    public static void main(String[] args) {

        // map of category to respective elements
        Map<String, ArrayList<String>> result = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number categories: ");
        int num = scan.nextInt();
        scan.skip("\n");

        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter Category: ");
            String category = scan.next(); // example: cars

            System.out.println("Enter comma separated elements: "); // example: scoda,bmw,suzuki
            String list = scan.next();

            // TODO Your work here to populate the map "result"
        }

        printFirstResult(result);

    }

    static void printFirstResult(Map<String, ArrayList<String>> result) {
        System.out.println("done");
        // TODO Print the first element of every category
        // Example: scoda from example given in line 31 above
    }

}
