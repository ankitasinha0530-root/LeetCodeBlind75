package com.practice.leetcode.blind75.string;

import com.practice.leetcode.blind75.linkedlist.LinkedListCircular;

public class MainLListTestCircular {

	public static void main(String[] args) {
		
		LinkedListCircular list = new LinkedListCircular();
		
		list.insert(2);
		list.insert(8);
		list.insert(9);
		list.insert(15);  // added last & we r inserting from first so 15 will be head and will print first;
		list.insert(14);
		list.insert(18);
		list.insert(24);
		
		list.display();
		
		System.out.println(list.delete(15));
		list.display();
		
		list.delete(27);
		
		System.out.println(list.delete(27));
		
		list.display();

	}

}
