package com.srikanth.interviews.LinkedLists;

public class ShiftLinkedList {

    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(0);
        headOne.next = new LinkedList(1);
        headOne.next.next = new LinkedList(2);
        headOne.next.next.next = new LinkedList(3);
        headOne.next.next.next.next = new LinkedList(4);
        headOne.next.next.next.next.next = new LinkedList(5);


        LinkedList newHead = shiftLinkedList(headOne, 2);

        LinkedList current = newHead;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {

        LinkedList cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (k < 0) {
            k = length - k;
        }
        k = k % length;

        LinkedList newHead = head;
        while (k-- > 0) {
            newHead = rotateOnce(newHead);
        }
        new java.util.ArrayList<>();

        return newHead;
    }

    static LinkedList rotateOnce(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        current.next = head;
        previous.next = null;

        return current;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}

