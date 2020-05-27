package com.srikanth.interviews.Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
        System.out.println(longestSubstringWithoutDuplication("a"));
        System.out.println(longestSubstringWithoutDuplication("abc"));
        System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
        }

    public static String longestSubstringWithoutDuplication(String str) {

        Queue<Character> characterFlow = new LinkedList<>();
        Map<Character, Boolean> visited = new HashMap<>();
        String subString = "";
        int longestSoFar = 0;
        boolean popHappened = false;

        for(int i=0; i< str.length(); i++) {
            char token = str.charAt(i);
            if(visited.containsKey(token)) {
                int queueSize = characterFlow.size();

                StringBuilder build = new StringBuilder();
                char head = characterFlow.peek();
                while(head != token){
                    char popped = characterFlow.poll();
                    build.append(popped);
                    visited.remove(popped);
                    head = characterFlow.peek();
                }
                char lastButOne = characterFlow.poll();
                build.append(lastButOne);
                visited.remove(lastButOne);
                build.append(characterFlow.peek());

                if(queueSize > longestSoFar) {
                    longestSoFar = queueSize;
                    subString = build.toString();
                }
                popHappened = true;
            }
            else {
                visited.put(token, true);
            }
            characterFlow.add(token);
        }

        if(!popHappened) {
            return str;
        }

        return subString;
    }


}

