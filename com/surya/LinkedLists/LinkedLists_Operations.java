package com.surya.LinkedLists;

/**
 * Created by skuchibh on 5/15/2017.
 */
public class LinkedLists_Operations extends LinkedList {

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

    private Node SortedIntersect(Node a, Node b) {
        if (a == null || b == null) {
            return null;
        }
        if ((Integer) a.data < (Integer) b.data) {
            return SortedIntersect(a.next, b);
        }
        if ((Integer) b.data < (Integer) a.data) {
            return SortedIntersect(a, b.next);
        }
        Node temp = new Node(a.data);
        temp.next = SortedIntersect(a.next, b.next);
        return temp;

    }

    public LinkedList SortedIntersect(LinkedList x, LinkedList y) {
        LinkedList res = new LinkedList();
        res.setHead(SortedIntersect(x.getHead(), y.getHead()));
        return res;

    }

}
