package com.srikanth.interviews.Tree;

import java.util.ArrayList;
import java.util.List;

public class RightSmaller {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(8);
        array.add(5);
        array.add(11);
        array.add(-1);
        array.add(3);
        array.add(4);
        array.add(2);
        rightSmallerThan(array);
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {

        List<Integer> rightSmaller = new ArrayList<>();

        int arraySize = array.size();

        if (arraySize == 0) {
            return rightSmaller;
        }
        if (arraySize == 1) {
            rightSmaller.add(0);
            return rightSmaller;
        }

        BST tree = new BST(array.get(arraySize - 1));
        System.out.print("0 ");
        for (int i = arraySize - 2; i >= 0; i--) {
            System.out.print(tree.insertAndGetMins(array.get(i), 0) + " ");
        }


        return new ArrayList<Integer>();
    }
}

class BST {
    int value;
    BST left = null;
    BST right = null;
    int leftSubTreeCount = 0;

    BST(int value) {
        this.value = value;
    }

    int insertAndGetMins(int newval, int currentMins) {
        if (newval >= this.value) {

            // if you are going right it is greater. then add 1.
            if (this.right == null) {
                this.right = new BST(newval);
                return 1 + currentMins + this.leftSubTreeCount;
            } else {
                return this.right.insertAndGetMins(newval, 1 + currentMins + this.leftSubTreeCount);
            }
        } else {
            // going left means adding one to parents left count
            if (this.left == null) {
                this.left = new BST(newval);
                this.leftSubTreeCount++;
                return currentMins;
            } else {
                return this.left.insertAndGetMins(newval, currentMins);
            }
        }
    }
}
