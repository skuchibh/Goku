package com.surya;

import com.surya.LinkedLists.LinkedList;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 0; i <= 8; i++) {
            llist.addLast(i + 20);
        }
        llist.print();llist.addLastWithNext(29,llist.getNodeAtIndex(0).next);
        System.out.println(llist.hasCycle());

    }
}
THIS IS VAMSI EDITING MAIN 
