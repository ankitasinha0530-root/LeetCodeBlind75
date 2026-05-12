package com.leetcode.blind75.arrays;

public class ReverseAnArrayInPlace {

    public static void main(String[] args) {

        int[] arr = {2, 5, 7, 8, 3, 5, 6, 9};

        reverseArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    //	In Place reversal of an array
    private static void reverseArray(int[] arr) {
        int temp;
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

}
