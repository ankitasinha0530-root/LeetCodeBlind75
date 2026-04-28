package com.practice.leetcode.blind75.linkedlist;

public class MainLListTestDoubly {

	public static void main(String[] args) {
		
		LinkedListDoubly list = new LinkedListDoubly();
		
		list.insertFirst(2);
		list.insertFirst(8);
		list.insertFirst(9);
		list.insertFirst(15);
		list.insertFirst(18);
		list.insertFirst(22);  // added last & we r inserting from first so 15 will be head and will print first;
		list.display();
		
		list.insertLast(24);
		
		System.out.println();
		list.display();
		
		list.insert(3,10);
		
		System.out.println();
		list.display();
		
		list.insertAfter(9, 12);
		
		System.out.println();
		list.display();
		
		list.insertAfter(24, 16);
		
		System.out.println();
		list.display();
		
		System.out.println("getOnIndex = " + list.get(1).value);
		
		System.out.println("getOnValue = " + (list.find(2)).value);
		
		System.out.println("getOnValue boolean = " + (24 == (list.find(24)).value));
		
//		System.out.println("getOnValue boolean = " + (98 == (list.find(98) == null ? 0 : ((list.find(98)).value))));
		
//		list.displayReverse();
		
//		list.insertLast(14);
//		list.insert(2, 10);
//		list.display();
		
//		System.out.println(list.deleteFirst());
//		list.display(); 
//		
//		System.out.println(list.deleteLast());
//		list.display();
//		
//		System.out.println(list.delete(2));
//		list.display();
//		
//		System.out.println("getOnIndex = " + list.get(1).value);
//		
//		System.out.println("getOnValue = " + (list.find(2)).value);
//		
//		System.out.println("getOnValue boolean = " + (2 == (list.find(2)).value));


	}

}
