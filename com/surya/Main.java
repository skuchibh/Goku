package com.surya;

import com.surya.LinkedLists.LinkedList;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 3; i < 10; i++) llist.addLast(i + 1);
        llist.print();
        llist.deleteNode(llist.getNodeAtIndex(3));
        llist.print();
        llist.deleteNode(llist.getNodeAtIndex(0));
        llist.print();



    }

}