package com.leetcode.blind75.linkedlist;

public class LinkedListCircular {

    // refer video - https://www.youtube.com/watch?v=58YbpRDc4yw

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size;

    public LinkedListCircular() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    public int delete(int value) {
        Node node = head;
        if (head == null) {
            System.out.println("linkedList Is empty");
            return 0;
        }

        if (node.value == value) {
            head = head.next;
            tail.next = head;
            return node.value;
        }
        Node n;
        do {
            n = node.next;
            if (n.value == value) {
                node.next = n.next;
                return n.value;   // /use  "break" when returning void
            }
            node = node.next;
        } while (node != head);
        return 0;

    }


    public Node find(int val) {
        Node node = head;
        if (head != null) {
            do {
                node = node.next;
            } while (node.value != val);
        }
        return node;
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + "->");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD"); // since it comes back again at head
    }
}
