package com.srikanth.interviews.AskedInInterview;

/*
Given a BST, identify the sum of elements in given range
Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]

output: 55
There are three nodes in range, 5, 10 and 40

 */


import java.util.LinkedList;
import java.util.Queue;

public class BSTRangeSum {
    private static int getSum(Tree root, int low, int high) {
        int sum = 0;
        Queue<Tree> dfs = new LinkedList<>();
        dfs.add(root);

        while (!dfs.isEmpty()) {
            Tree node = dfs.poll();
            if (node != null) {
                if (node.data >= low && node.data <= high) {
                    sum += node.data;
                }
                if (node.data > low) {
                    dfs.add(node.left);
                }
                if (node.data < high) {
                    dfs.add(node.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Tree bst = new Tree(10);
        bst.left = new Tree(5);
        bst.right = new Tree(50);
        bst.left.left = new Tree(1);
        bst.right.left = new Tree(40);
        bst.right.right = new Tree(100);

        int low = 5, high = 45;
        System.out.println(getSum(bst, low, high));
    }

    private static class Tree {
        int data;
        Tree left, right;

        Tree(int data) {
            this.data = data;
        }
    }
}
