package com.surya;

import com.surya.LinkedLists.LinkedList;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.addFirst(0);
        list1.addLast(1);
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(0);
        list1.addLast(1);
        list1.print();
        LinkedList[] res = list1.subLists_Alternate();
        for (LinkedList x : res) x.print();
        Comparable[] tmp = new Comparable[5];


    }

}