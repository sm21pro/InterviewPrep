package com.srikanth.interviews.Tree;

import java.util.*;

public class MultiStringSearch {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        // holds containedWords
        Set<String> containedWords = new HashSet<>();

        Trie trie = new Trie();
        // Trie for small Strings
        for (String small : smallStrings) {
            trie.insertString(small);
        }

        // iterate bigString
        for (int i = 0; i < bigString.length(); i++) {
            findContainedStrings(bigString, i, trie, containedWords);
        }

        List<Boolean> result = new ArrayList<>();

        // compare contained with small Strings
        System.out.println(containedWords);
        for (String word : smallStrings) {
            result.add(containedWords.contains(word));
        }
        return result;
    }

    static void findContainedStrings(String string, int index, Trie trie, Set<String> containedWords) {

        TrieNode currentNode = trie.root;
        for (int i = index; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!currentNode.children.containsKey(letter)) {
                break;
            }
            currentNode = currentNode.children.get(letter);
            // check for end of word at each character
            if (currentNode.children.containsKey(trie.endSymbol)) {
                containedWords.add(currentNode.word);
            }
        }

    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    static class Trie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public void insertString(String str) {
            TrieNode node = root;

            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
            node.word = str;
        }

    }
}


