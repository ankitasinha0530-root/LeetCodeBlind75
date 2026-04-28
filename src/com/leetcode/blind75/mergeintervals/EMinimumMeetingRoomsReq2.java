package com.practice.leetcode.blind75.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class EMinimumMeetingRoomsReq2 {

	public static void main(String[] args) {
		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting(6, 7));
		meetings.add(new Meeting(2, 5));
		meetings.add(new Meeting(8, 12));
		System.out.println(noOfMeetingRoomRequired(meetings));
		
		List<Meeting> meetings1 = new ArrayList<>();
		meetings1.add(new Meeting(1, 4));
		meetings1.add(new Meeting(2, 5));
		meetings1.add(new Meeting(7, 9));
		System.out.println(noOfMeetingRoomRequired(meetings));
	}

	private static int noOfMeetingRoomRequired(List<Meeting> meetings) {
		if(meetings == null || meetings.size() == 0) {
			return 0;
		}
		int minMeetingRooms = 0;
		Collections.sort(meetings, Comparator.comparing(i -> i.start));
		
		PriorityQueue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(), Comparator.comparing(i -> i.end));
	//	PriorityQueue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
		for(Meeting meeting : meetings) {
			// remove all meetings that have ended before this iteration meeting start from minHeap
			while(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) { 
				minHeap.poll(); // if not overlapping then we dont need more rooms, we can multiple meetings in 1 single room
			}
			// add the current meeting into the minHEap
			minHeap.offer(meeting);
			// All active meetings are in minHeap, so we need separate meeting rooms for all these meeting
			minMeetingRooms = Math.max(minMeetingRooms, minHeap.size());
		}
		return minMeetingRooms;
	}

}
