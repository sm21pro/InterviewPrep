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

            // list is of type String. But map take values as ArrayList.
            // Define an array list
            ArrayList<String> inputList = new ArrayList<>();

            // input is comma separated values. So splitting them to an array. Ex: "scoda,bmw,suzuki" becomes ["scoda", "bmw", "suzuki"]
            String[] inputArray = list.split(",");

            // add each input to array list
            for (String input : inputArray) {
                inputList.add(input);
            }

            // now add the array list to category key in map
            result.put(category, inputList); // cars: ["scoda", "bmw", "suzuki"]
        }

        printFirstResult(result);

    }

    static void printFirstResult(Map<String, ArrayList<String>> result) {

        // TODO Print the first element of every category
        // Example: scoda from example given in line 31 above
        for (String category : result.keySet()) {
            // now value for this category key will be in array list format
            ArrayList<String> value = result.get(category);
            // Print key and first element
            System.out.println(category + ": " + value.get(0));

            // the 2 lines above can be written as follows
            // System.out.println(category + ": " + result.get(category).get(0));
        }

    }

}
