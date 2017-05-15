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
        for (int i = 1; i < 21; i += 2) {
            llist.addLast(i);
            llist2.addLast(i + 1);
        }
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