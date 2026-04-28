package com.practice.leetcode.blind75.linkedlist;

public class LinkedListSingly {
	
	//refer video -- https://www.youtube.com/watch?v=58YbpRDc4yw
	
	class Node{
		int value;
		Node next; // next is reference variable pointing to next element which as on object present on heap of type Node
		
		public Node(int value) {  //overloaded constructor of Node with value
			this.value = value;
		}
		
		public Node(int value, Node next) { //overloaded constructor of Node with value and next
			this.value = value;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListSingly() {   //constructor of LList
		this.size = 0;
	}
	
	public void insert(int val) {
		Node newNode = new Node(val);
		
		 //Checks if the list is empty    
		if(head == null) {
	         //If list is empty, both head and tail will point to new node    
			head = newNode;
			tail = newNode;
		}else {
			  //newNode will be added after tail such that tail's next will point to newNode    
			tail.next = newNode;
			tail = newNode ;    //newNode will become new tail of the list     
		}
		size++;
	}
	
	public void insert(int index, int val) {
		if(index == 0) {
			insertFirst(val);
			return;
		}
		if(index == size) {
			insertLast(val);
			return;
		}
		Node temp = head;
		for(int i=1; i < index; i++) {
			temp = temp.next;  // node at previous position of given input index 
		}
		Node node = new Node(val, temp.next); // new node is created with input value and previous postion's next node info
		temp.next = node;  // previous index next is updated with new node created
		size++;
	}

	public void insertFirst(int val) {  // Insert / add method in linked List
		Node node = new Node(val);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = head;
		}
		size += 1;
	}
	
	public void insertLast(int val) { // Complexity will be O(N) if tail is not declared since traversing through whole list 
 		Node node = new Node(val);		// else Complexity o(1) if tail is declared, as we can directly go to tail.
		if(tail == null) {
			insertFirst(val);
		}
		tail.next = node;
		tail = node;
		size++;
	}
	
	public int delete(int index) {  // Complexity O(N), since we rae traversing
		if(index == 0) {
			return deleteFirst();
		}
		if(index == size-1) {
			return deleteLast();
		}
		Node prevNode = get(index-1);
		int val = prevNode.next.value;
		prevNode.next = prevNode.next.next;
		return val;
	}
	
	public int deleteFirst() {
		int val = head.value;
			head = head.next; 
			// if there was only one element in the list which is removed then head will become null so tail will also become null
			if(head == null) {; 
				tail = head;
			}
			size--;
			return val;
	}
	
	public int deleteLast() {   //Complexity is O(N) .since traversing through whole list
		if(size <= 1) {
			return deleteFirst();
		}
		Node secLastNode = get(size-2);
		int val = tail.value; //or secLastNode..next.value;
		tail = secLastNode;
		tail.next = null;
		return val;
	}
	
	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	public Node findValue(int value) {
		Node node = head;
		while(node != null) {
			if(node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
		
	}
	
	public void display() {
		Node currNode = head;
		while(currNode != null) {
			System.out.print(currNode.value + " -> ");
			currNode = currNode.next;
		}
		System.out.println(" END ");
	}
	
//	refer video -- https://www.youtube.com/watch?v=71NqKy7287g, https://www.youtube.com/watch?v=D2vI2DNJGd8
	public Node reverseIterative() {  // https://www.youtube.com/watch?v=Tk_fi5l8cag  
		 
		Node prevNode = head;
		Node currNode = head.next;
		
		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		
		head.next = null;
		head = prevNode;
		
		return head;
		
	}
	
	
	

}
