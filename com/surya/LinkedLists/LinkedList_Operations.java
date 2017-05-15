package com.surya.LinkedLists;

/**
 * Created by skuchibh on 5/15/2017.
 */
public class LinkedList_Operations extends LinkedList {

    public Node SortedMerge(Node a, Node b) {

        //Sorts and merges 2 LinkedLists  which are already sorted individually.



        Node res = null;
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        if ((int) a.data <= (int) b.data) {
            res = a;
            res.next = SortedMerge(a.next, b);
        } else {
            res = b;
            res.next = SortedMerge(a, b.next);
        }
        return res;
    }


}
