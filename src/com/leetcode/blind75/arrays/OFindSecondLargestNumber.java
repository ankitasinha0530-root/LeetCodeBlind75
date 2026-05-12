package com.leetcode.blind75.arrays;

import java.util.PriorityQueue;

public class OFindSecondLargestNumber {

    public static void main(String[] args) {

        System.out.println("value = " + OFindSecondLargestNumber.findKthLargestNumber(new int[]{3, 1, 5, 12, 2, 11}, 2));
        System.out.println("value = " + OFindSecondLargestNumber.findKthLargestNumber(new int[]{5, 11, -1, 12}, 3));
        System.out.println("value = " + OFindSecondLargestNumber.findKthLargestNumber(new int[]{3, 5, 0, 1, 6, 4, 7, 2, 9}, 3));

        System.out.println("value V2 = " + OFindSecondLargestNumber.findKthLargestNumberV2(new int[]{5, 11, -1, 12}));
        System.out.println("value V2 = " + OFindSecondLargestNumber.findKthLargestNumberV2(new int[]{3, 5, 0, 1, 6, 4, 7, 2, 9}));

    }

    private static int findKthLargestNumber(int[] arr, int i) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int j = 0; j < arr.length; j++) {
            if (minHeap.size() == i) {
                if (minHeap.peek() < arr[j]) {
                    minHeap.poll();
                    minHeap.add(arr[j]);
                }
            } else {
                minHeap.add(arr[j]);
            }
        }
        return minHeap.poll();
    }

    // 2nd way to do it
    private static int findKthLargestNumberV2(int[] arr) {

        int first, second;

        first = second = Integer.MIN_VALUE;
        if (arr.length < 2) {
            return -1;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > first) {
                second = first;
                first = arr[j];
            }
            if (arr[j] > second && arr[j] != first) {
                second = arr[j];
            }
        }
        if (second == Integer.MIN_VALUE) {
            return -1;
        }
        return second;
    }

}
