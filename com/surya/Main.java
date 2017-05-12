package com.surya;

import com.surya.LinkedLists.LinkedList;

/**
 * Created by skuchibh on 4/26/2017.
 */

//REMOVED CYCLE CONDITION

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        /*for (int i = 0; i <= 8; i++) {
            llist.addLast(i + 20);
        }*/
        for (int i = 0; i < 30; i++) {
            llist.addLast(i + 20);
        }
        llist.print();
        System.out.println(llist.hasCycle());

    }
}