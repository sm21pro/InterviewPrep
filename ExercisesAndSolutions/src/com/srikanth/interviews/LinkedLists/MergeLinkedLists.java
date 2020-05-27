package com.srikanth.interviews.LinkedLists;

public class MergeLinkedLists {

    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(2);
        headOne.next = new LinkedList(6);
        headOne.next.next = new LinkedList(7);
        headOne.next.next.next = new LinkedList(8);
        LinkedList headTwo = new LinkedList(1);
        headTwo.next = new LinkedList(3);
        headTwo.next.next = new LinkedList(4);
        headTwo.next.next.next = new LinkedList(5);
        headTwo.next.next.next.next = new LinkedList(9);
        headTwo.next.next.next.next.next = new LinkedList(10);

        mergeLinkedLists(headOne, headTwo);
    }

    // This is an input class. Do not edit.
    static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList hOne = headOne;
        LinkedList hTwo = headTwo;
        LinkedList hTwoPrev = null;

        while (hOne != null && hTwo != null) {
            if (hTwo.value > hOne.value) {
                // copy h1 to prev
                hTwoPrev = hOne;
                // move h1
                hOne = hOne.next;
                // attach h2 to prev
                hTwoPrev.next = hTwo;
            } else {
                // copy h2 to prev, move head two
                hTwoPrev = hTwo;
                hTwo = hTwo.next;
            }
            print(headOne, headTwo);
        }
        // System.out.println(hOne.value);
        System.out.println(hTwo.value);


        return null;
    }

    static void print(LinkedList one, LinkedList two) {
        LinkedList cur1 = one, cur2 = two;
        while(cur1 != null) {
            System.out.print(cur1.value + " ");
            cur1 = cur1.next;
        }
        System.out.println();
        while(cur2 != null) {
            System.out.print(cur2.value + " ");
            cur2 = cur2.next;
        }
        System.out.println();
        System.out.println();
    }
}

