package com.surya;

import com.surya.LinkedLists.LinkedList;
import com.surya.LinkedLists.LinkedList_Operations;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        LinkedList<Integer> llist2 = new LinkedList<>();
        llist.addFirst(5);
        llist.addLast(10);
        llist.addLast(15);
        llist2.addFirst(2);
        llist2.addLast(3);
        llist2.addLast(20);
        llist.print();
        llist2.print();
        LinkedList_Operations op = new LinkedList_Operations();
        LinkedList.Node res = op.SortedMerge(llist.getHead(), llist2.getHead());
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }

}