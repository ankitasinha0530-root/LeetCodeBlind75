package com.practice.leetcode.blind75.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AMergeIntervals {

	public static void main(String[] args) {

		// refer video - https://www.youtube.com/watch?v=dzNIPX7HY6A
		// https://www.youtube.com/watch?v=dzNIPX7HY6A&t=1s
		
		int[][] intervals =  {{1,2}, {6,8}, {2,5}};
		int[][] result = mergeIntervals(intervals);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + ", " + result[i][1]);
		}
	//	System.out.println(mergeIntervals(intervals)); 

	}

	static int[][] mergeIntervals(int[][] intervals) {

		if (intervals.length <= 1) {
			return intervals;
		}
		Arrays.sort(intervals, Comparator.comparing((i) -> i[0]));
		
		List<int[]> result = new ArrayList<>();
		
		int[] newInterval = intervals[0];
		result.add(newInterval);
		
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) {
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
			
		}
		return result.toArray(new int[result.size()][]);
	}
	
	static int[][] mergeIntervalsV2(int[][] intervals) {

		Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] currInterval = intervals[0];
        for(int i = 0; i < intervals.length; i++){
            if(currInterval[1] >= intervals[i][0]){
                 if( currInterval[1] < intervals[i][1]){
                      currInterval[1] = intervals[i][1];
                 }
                //or
                //currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
                if((currInterval[0] > intervals[i][0])){
                    currInterval[0] = intervals[i][0];
                }
            }else{
                result.add(currInterval);
                currInterval = intervals[i];
            }
        }
        result.add(currInterval);
        return result.toArray(new int[result.size()][]);
    }

}
