package com.srikanth.interviews.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MoveToEnd {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(2);
        moveElementToEnd(array, 2);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int i = 0, j = array.size() - 1;

        //  [2, 1, 2, 2, 2, 3, 4, 2]
        //   0  1  2  3  4  5  6  7


        while (i < j) {


            if (array.get(i) == toMove) {
                // r-- until we reach not 2
                while (array.get(j) == toMove) {
                    j--;
                }
                if (j < i) {
                    break;
                }
                swap(array, i, j);
                System.out.println(array);
                System.out.print(" ");
                for (int k = 0; k < array.size(); k++) {
                    System.out.print(k + "  ");
                }
                System.out.println();
                j--;
            } else {
                i++;
            }
        }

        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

