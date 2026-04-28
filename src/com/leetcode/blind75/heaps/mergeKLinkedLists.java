package com.practice.leetcode.blind75.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
		
		PriorityQueue<ListNode> minHeapUsingComparator = new PriorityQueue<>(Comparator.comparing(a -> a.value));
		
		// put all the elements from all the list to minHeap so that all the elements remain in sorted manner(natural sorting)
		for (int i = 0; i < lists.length; i++) {
			ListNode x = lists[i];
			while (x != null) {
				minHeap.add(x);
				x = x.next;
			}
		}

		ListNode head = minHeap.poll();
		ListNode temp = head;
		
//		extract elements one by one and construct a linked list
		while (minHeap.size() > 0) {
			temp.next = minHeap.poll();
			temp = temp.next;
		}
		if (temp != null) {
			temp.next = null;
		}
	//	return head of linkedlist after contructing the list;
		return head;
	}
}
