package com.practice.leetcode.blind75.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EMinimumMeetingRoomsReq {

	public static void main(String[] args) {

		// refer Video - https://www.youtube.com/watch?v=bgZmJiPfkYE
		// refer video = https://www.youtube.com/watch?v=s8oOsWGHIl4
		// Use Priority Queue to store the non-unique meetings to calculate number of
		// rooms
		// priority queue sorts the elements - and keep the meeting at first which is
		// ending first
		// we need only end time so will only store end time in our priority for each
		// meeting

		int[][] intervals = { { 6, 7 }, { 2, 5 }, { 8, 12 } }; // output = 1
		System.out.println(noOfMeetingRoomRequired(intervals)); // min no.of meeting rooms required

		int[][] intervals1 = { { 1, 4 }, { 2, 5 }, { 7, 9 } }; // output = 2
		System.out.println(noOfMeetingRoomRequired(intervals1));
	}

	private static int noOfMeetingRoomRequired(int[][] intervals) {
		int minMeetingRooms = 0;
		Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
		// below both ways are correct
//		PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> Integer.compare(a[1], b[1]));
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparing(i -> i[1]));
		for(int[] interval : intervals) {
			// remove all meetings that have ended before this iteration meeting start from minHeap
			while(!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) { 
				minHeap.poll(); // if not overlapping then we dont need more rooms, we can have multiple meetings in 1 single room
			}
			// add the current meeting into the minHeap
			minHeap.offer(interval);
			// All active meetings are in minHeap, so we need separate meeting rooms for all these meeting
			minMeetingRooms = Math.max(minMeetingRooms, minHeap.size());
		}
		return minMeetingRooms;
	}

}
