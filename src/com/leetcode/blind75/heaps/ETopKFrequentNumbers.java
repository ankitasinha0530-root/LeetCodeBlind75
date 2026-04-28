 package com.practice.leetcode.blind75.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ETopKFrequentNumbers {

	public static void main(String[] args) {

//		Map.Entry<Integer, Integer> == interface in Java provides certain methods to access the entry in the Map.
//		By gaining access to the entry of the Map we can easily manipulate them. 
//		Map.Entry is a generic and is defined in the java.util package.

		System.out.println("Elements 1 = " + ETopKFrequentNumbers.topKFrequentNumbers(new int[] {1, 3, 5, 12, 11, 12, 11 }, 3));
		System.out.println("Elements 2 = " + ETopKFrequentNumbers.topKFrequentNumbers(new int[] {5, 12, 11, 3, 11}, 2));

	}

	private static List<Integer> topKFrequentNumbers(int[] arr, int k) {

		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		// add all the elements and its frequency in hashmap
		for (int i = 0; i < arr.length; i++) {
			freqMap.put(arr[i],  freqMap.getOrDefault(arr[i], 0) +1);
		}
		
		// defina priorityQueue
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
				new PriorityQueue<Map.Entry<Integer, Integer>>((i1, i2) -> i1.getValue() - i2.getValue());
		
		// add elements in minHeap and remove element if the size becomes greater than k
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		// add all the keys present in hashmap to arraylist 
		List<Integer> result = new ArrayList<>();
		while(minHeap.size() > 0) {
			result.add(minHeap.poll().getKey());
		}
		return result;
	}

}
