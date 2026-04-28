package com.practice.leetcode.blind75.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class CMakeNonOverLappingIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(removeOverLappingIntervals(intervals));
		
		int[][] intervals1 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 } };
		System.out.println(removeOverLappingIntervals(intervals1));
	}

	public static int removeOverLappingIntervals(int[][] intervals) {
		int count = 0;
		Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {  // check if the elements are overlapping 
				intervals[i][1] = intervals[i - 1][1];	// if yes then change the [1]element with previous interval
				count++;
			}
		}

		return count;
	}

}
