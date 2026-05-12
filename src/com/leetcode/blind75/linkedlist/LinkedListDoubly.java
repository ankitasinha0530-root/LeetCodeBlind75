package com.practice.leetcode.blind75.linkedlist;

public class LinkedListDoubly {

    //refer video -- https://www.youtube.com/watch?v=58YbpRDc4yw

    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            super();
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            super();
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head; // for head previous node is null
    //	private Node tail; // for head next node is null
    private int size;

    public LinkedListDoubly() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.prev = null;
        node.next = head;
        if (head != null) { // to check if head != null when inserting for the very first time
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        node.next = null;
        if (head == null) {
            node.prev = null;  // or insertFirst(value);
            head = node;
            return;
        }
        Node tempLast = head;
        while (tempLast.next != null) {
            tempLast = tempLast.next;
        }
        node.prev = tempLast;
        tempLast.next = node;
        size++;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);

        if (index == 0) {
            insertFirst(value);
        }
        if (index == size) {
            insertLast(value);
        }
        Node temp = get(index - 1);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public void insertAfter(int after, int value) {
        Node newNode = new Node(value);
        Node temp = find(after);
        if (temp == null) {
            System.out.println("node not found");
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp.value != value) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;      // by end of this loop last will point to actual last node
            node = node.next;
        }
        System.out.println("END");
        System.out.println("Print in Reverse");

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;      // by end of this loop last will point to actual last node
        }
        System.out.println("START");
    }

    public void displayReverse() {
        // TODO Auto-generated method stub

    }

}
