package com.surya;

import com.surya.LinkedLists.LinkedList;
import com.surya.LinkedLists.LinkedLists_Operations;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) list1.addLast(i + 1);
        for (int i = 5; i < 14; i++) list2.addLast(i);
        list1.print(list1.getHead());
        list2.print(list2.getHead());
        LinkedLists_Operations ops = new LinkedLists_Operations();
        LinkedList combinedList = ops.SortedIntersect(list1, list2);
        combinedList.print(combinedList.getHead());

    }

}