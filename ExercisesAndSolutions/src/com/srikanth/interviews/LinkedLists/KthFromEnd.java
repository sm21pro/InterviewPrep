package com.srikanth.interviews.LinkedLists;

public class KthFromEnd {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        LinkedList current = head;
        for (int i = 1; i < 10; i++) {
            current.next = new LinkedList(i);
            current = current.next;
        }
        removeKthNodeFromEnd(head, 10);

        current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        if (k == 0) {
            return;
        }

        // find length
        int length = 0;
        LinkedList current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int kCompliment = length - k;

        LinkedList previous = null;
        current = head;
        while (current != null && kCompliment-- > 0) {
            previous = current;
            current = current.next;
        }

        // reached there. Delete it.
        if (previous != null) {
            previous.next = current.next;
        } else { // first element
            head = head.next;
        }


    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

