package com.practice.leetcode.blind75.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class DConflictingAppointments {

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		System.out.println(canAttendAllAppointements(intervals));
		
		int[][] intervals1 =  {{1,3}, {6,8}, {2,5}};
		System.out.println(canAttendAllAppointements(intervals1));
	}
	
	public static boolean canAttendAllAppointements(int[][] intervals) {
		
		Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
		
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] < intervals[i-1][1]) { // if overlapping then return false
				return false;
			}
		}
		return true;
	}
}
