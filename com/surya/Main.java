package com.surya;

import com.surya.LinkedLists.LinkedList;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 3; i < 11; i++) llist.addLast(i + 1);
        llist.print(llist.getHead());
        llist.moveLastNodeToFirst();
        llist.print(llist.getHead());


    }

}