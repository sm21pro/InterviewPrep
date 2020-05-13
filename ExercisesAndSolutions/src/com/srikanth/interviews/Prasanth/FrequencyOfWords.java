package com.srikanth.interviews.Prasanth;

/*
You are given a Sentence with only Strings and whitespaces.
Complete method that returns a map of String and Integer that contain frequency of each word in the sentence
Constraints: characters are treated case insensitive. Keys in result map returned must be lowercase

Ex: My name is Prasanth but my parents call me chinna not Prasanth
Output: {{my, 2}, {name, 1}, {is, 1}, {prasanth, 2}, {but, 1}, {parents, 1}, {call, 1}, {me, 1}, {chinna, 1}, {not, 1}}
 */

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords {


    private static HashMap<String, Integer> getFrequencyOfWords(String sentence) {

        // Your code here
        return null;
    }


    public static void main(String[] args) {
        String a = "My name is Prasanth but my parents call me chinna not Prasanth";
        Map<String, Integer> expected = new HashMap<>() {{
            put("my", 2);
            put("name", 1);
            put("is", 1);
            put("prasanth", 2);
            put("but", 1);
            put("parents", 1);
            put("call", 1);
            put("me", 1);
            put("chinna", 1);
            put("not", 1);
        }};
        System.out.println(expected.equals(getFrequencyOfWords(a)));

        a = "tim tom timmed tim not tom";
        expected = new HashMap<>() {{
            put("tim", 2);
            put("tom", 2);
            put("timmed", 1);
            put("not", 1);
        }};
        System.out.println(expected.equals(getFrequencyOfWords(a)));
    }


}
