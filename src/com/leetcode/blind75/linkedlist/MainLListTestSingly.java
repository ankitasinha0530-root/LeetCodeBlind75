package com.leetcode.blind75.linkedlist;

public class MainLListTestSingly {

    public static void main(String[] args) {

        LinkedListSingly list = new LinkedListSingly();

//		List<Integer> llist = new LinkedList<>();
//		llist.reversed()

        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(9);
        list.insertFirst(15);  // added last & we r inserting from first so 15 will be head and will print first;
        list.insertLast(14);
        list.insert(2, 10);

        list.display();

        System.out.println("getOnIndex 1 = " + list.get(1).value);
        System.out.println(list.delete(2));
        list.display();

        System.out.println(list.deleteFirst());
        list.display();

        System.out.println(list.deleteLast());
        list.display();

        System.out.println(list.delete(2));
        list.display();

        System.out.println("getOnIndex = " + list.get(1).value);

        System.out.println("getOnValue = " + (list.findValue(2)).value);

        System.out.println("getOnValue boolean = " + (2 == (list.findValue(2)).value));


    }

}
