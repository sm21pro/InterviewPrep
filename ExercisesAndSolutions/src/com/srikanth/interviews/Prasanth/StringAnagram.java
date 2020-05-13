package com.srikanth.interviews.Prasanth;

/*
You are given two Strings. Complete method that returns true if both words are anagrams.
Constraints:
  Ignore any characters other than alphabets
  Alphabets are case-insensitive. A and a are equal
Ex: dusty, study
Output: true
 */

public class StringAnagram {
    public static void main(String[] args) {
        String a = "enigma";
        String b = "gamine";
        boolean expected = true;
        System.out.println(expected == isAnagram(a, b));

        a = "madam";
        b = "adam";
        expected = false;
        System.out.println(expected == isAnagram(a, b));

        a = "Clint Eastwood";
        b = "Old West action";
        expected = true;
        System.out.println(expected == isAnagram(a, b));

        a = null;
        b = "";
        expected = false;
        System.out.println(expected == isAnagram(a, b));

    }


    private static boolean isAnagram(String a, String b) {

        // Your code here
        return false;
    }
}
