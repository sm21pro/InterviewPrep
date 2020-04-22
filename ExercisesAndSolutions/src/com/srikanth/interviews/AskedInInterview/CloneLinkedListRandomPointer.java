package com.srikanth.interviews.AskedInInterview;

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list within O(1) space.
          ------
         |     |
         V     ^
7-->13-->11-->10--> 1 -->null
^        V        ^ V
|        |________| |
|___________________|

Random pointers: 11 to 1; 10 to 11; 1 to 7
 */

public class CloneLinkedListRandomPointer {

    private static void printCopy(Node root) {

        System.out.println("Before Copy:");
        print(root);

        // Attach a copy of node to each node
        // 7-->[7]-->13-->[13]-->11-->[11]-->10-->[10]-->1-->[1]-->null
        Node curr = root;
        Node originalNext = null;
        while (curr != null) {
            originalNext = curr.next; // 13
            curr.next = new Node(curr.data); // [7]
            curr.next.next = originalNext; // 7 - [7] - 13

            curr = originalNext; // 13
        }
        System.out.println("Copy Step 1:");
        print(root);

        // Transfer random pointers to duplicates
        curr = root;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        System.out.println("Copy Step 2:");
        print(root);

        // isolate duplicate to separate list
        curr = root;
        Node copy = root.next;
        Node copyCurr = root.next;
        while (curr != null) {
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        System.out.println("After Copy Original:");
        print(root);
        System.out.println("After Copy Copied:");
        print(copy);
    }

    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        eleven.random = one;
        ten.random = eleven;
        one.random = seven;

        Node list = seven;
        list.next = thirteen;
        list.next.next = eleven;
        list.next.next.next = ten;
        list.next.next.next.next = one;

        printCopy(list);
    }

    private static void print(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.data + "(" + (curr.random != null ? curr.random.data : "") + ") " + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static class Node {
        int data;
        Node next, random;

        Node(int data) {
            this.data = data;
            Node next = null, random = null;
        }
    }
}
