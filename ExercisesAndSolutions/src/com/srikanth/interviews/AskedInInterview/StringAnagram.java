package com.srikanth.interviews.AskedInInterview;

// check if string is an anagram

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {

    public static void main(String[] args) {
        String s1 = "rat";
        String s2 = "art";
        System.out.println(isAnagram(s1, s2));

        // how to check Strings with special symbols
        s1 = "r@t#";
        s2 = "@r#t";
        System.out.println(isAnagramSpecial(s1, s2));

    }

    private static boolean isAnagramSpecial(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            // Increment the counter for S1
            charCount.put(s1.charAt(i), charCount.getOrDefault(s1.charAt(i), 0) + 1);

            // Decrement same for S2
            charCount.put(s2.charAt(i), charCount.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sortedString(s1).equalsIgnoreCase(sortedString(s2));
    }

    // sort string in O(n)
    private static String sortedString(String str) {
        int utf8 = 256;
        int[] chars = new int[utf8];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }
        String sorted = "";
        for (int i = 0; i < utf8; i++) {
            for (int j = 0; j < chars[i]; j++) {
                sorted += (char) (i + 'a');
            }
        }
        return sorted;
    }
}
