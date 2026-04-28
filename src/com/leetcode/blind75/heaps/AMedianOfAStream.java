package com.practice.leetcode.blind75.heaps;

import java.util.PriorityQueue;

public class AMedianOfAStream {
	
	// Refer video = https://www.youtube.com/watch?v=dshWERdcAdg - for another solution of pepcoding
	
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	
	// constructor
	public AMedianOfAStream(){ // Initialize maxHEap and minHEap in constructor
		// Store 1st half of the number
		maxHeap = new PriorityQueue<>((a, b) -> b-a);	 // Priority to highest number descending order queue
		// Store 2nd half of the number
		minHeap = new PriorityQueue<>((a, b) -> a-b);	 // Priority to smallest number ascending order queue
		
	}
	
	public void insertNum(int num) {
		
		// add elements in maxHeap and minHeap
		if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		}else {
			minHeap.add(num);
		}
		
		// Balance data between maxHeap and MinHeap
		
		if(maxHeap.size() > minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
		}else if(maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}
	
	public double findMedian() {
		
		if(maxHeap.size() == minHeap.size()) {
	//		System.out.println("maxHeap.peek()/2 + minHeap.peek()/2  = " 
		//						+ ((double)(maxHeap.peek() + minHeap.peek())/2)); // either cast double or divide by double number to get output in double
			return maxHeap.peek()/2.0 + minHeap.peek()/2.0; // always divide a double number by double to get result in double
		}
	//	System.out.println("maxHeap.peek() = " + maxHeap.peek());
		return maxHeap.peek();
	}

	public static void main(String[] args) {

		AMedianOfAStream medianOfAStream = new AMedianOfAStream();
		
		medianOfAStream.insertNum(1);
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(2);
		
		System.out.println("Median of A Stream 1 = " + medianOfAStream.findMedian());
		
		medianOfAStream.insertNum(9);
		System.out.println("Median of A Stream 2 = " + medianOfAStream.findMedian());
		
		medianOfAStream.insertNum(6);
		System.out.println("Median of A Stream 3 = " + medianOfAStream.findMedian());
		
		medianOfAStream.insertNum(7);
		System.out.println("Median of A Stream 4 = " + medianOfAStream.findMedian());
		

	}

}
