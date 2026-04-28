package com.practice.leetcode.blind75.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class BInsertInterval {

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[]	newInterval = {4,8}; //Output: {{1,2},{3,10},{12,16}}
	//	Explanation : Because the new interval {4,8} overlaps with {3,5},{6,7},{8,10}.
		int[][] intervals1 = {{1,3},{6,9}};
		int[] newInterval1 = {8, 10};

		int[][] result = insertInterval(intervals, newInterval);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + ", " + result[i][1]);
		}
		System.out.println();
		int[][] result1 = insertInterval(intervals1, newInterval1);
		for (int i = 0; i < result1.length; i++) {
			System.out.println(result1[i][0] + ", " + result1[i][1]);
		}
	}

	private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		
		for (int i = 0; i < intervals.length; i++) {
			if(newInterval[1] < intervals[i][0]) {
				result.add(newInterval);
				while(i < intervals.length) {
					result.add(intervals[i]);
					i++;
				}
				return result.toArray(new int[result.size()][]);
			}else if(newInterval[0] > intervals[i][1]) {
				result.add(intervals[i]);
			}else {
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			}
		}
		
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}

	
}
