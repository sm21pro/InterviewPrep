package com.srikanth.interviews.FacebookExercises;

// Add any extra import statements you may need here


class ReverseEvenSubsets {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here
    // Add any helper functions you may need here
    static boolean isEven(Node node) {
        return node.data % 2 == 0;
    }

    static Node reverseMN(Node node, int m, int n) {
        if (node == null) {
            return null;
        }

        Node curr = node, prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        // now iterate until n becomes 0. Its basically m to n ratio maintained by reducing m and n
        // mark con and tail to fix connection at the end
        Node con = prev, tail = curr;

        // A-> B -> C reveresal - third is C, curr is B and prev = A
        Node third = null;

        while (n > 0) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        // fix the connection for total reverse
        if (con != null) {
            con.next = prev;
        } else {
            node = prev;
        }

        tail.next = curr;
        return node;

    }

    Node reverse(Node head) {
        // Write your code here
        Node curr = head;
        // 1, 2, 8, 9, 12, 16
        int m = 1, n = 1;
        while (curr != null) {
            if (isEven(curr)) {
                curr = curr.next;
                while (curr != null && isEven(curr)) {
                    n++;
                    curr = curr.next;
                }
                // apply reverse here. Curr pointing to next already
                head = reverseMN(head, m, n);
                m = n + 1;
                n = m;
            } else {
                curr = curr.next;
                m++;
                n++;
            }
        }
        return head;

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }

    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(StringManipulations[] args) {
        new ReverseEvenSubsets().run();
    }
}
