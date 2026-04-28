package com.practice.leetcode.blind75.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLinkedLists2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKListsV2(ListNode[] lists) {
		return null;

		// step 1 : One More approach is to merge 2 lists first
		// and then keep on merging the next lists to output list of step 1 one by one
	}

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}

	private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}
		if (start + 1 == end) {
			return merge(lists[start], lists[end]);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeKListsHelper(lists, start, mid);
		ListNode right = mergeKListsHelper(lists, mid + 1, end);
		return merge(left, right);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		curr.next = (l1 != null) ? l1 : l2;

		return dummy.next;
	}
}
