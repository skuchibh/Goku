package com.surya.LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by skuchibh on 4/26/2017.
 */
public class LinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> head;
    //private AnyType cycleStart = null, cycleEnd = null;

    public LinkedList() {
        head = null;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(AnyType item) {
        head = new Node<AnyType>(item, head);
    }

    public AnyType getFirst() {
        if (head != null) return head.data;
        else
            throw new NoSuchElementException();
    }


    public AnyType removeFirst() {
        AnyType tmp = getFirst();
        head = head.next;
        return tmp;
    }

    public void addLast(AnyType item) {
        if (head == null) addFirst(item);
        else {
            Node<AnyType> tmp = head;
            while (tmp.next != null) tmp = tmp.next;
            tmp.next = new Node<AnyType>(item, null);
        }
    }

    public Node removeDuplicates() {
        if (head == null) throw new NoSuchElementException("EMPTY");
        Node prev = head;
        Node cur = head.next;
        HashSet<AnyType> set = new HashSet<>();
        set.add(head.data);
        while (cur != null) {
            if (set.contains(cur.data)) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                set.add((AnyType) cur.data);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;

    }

    public void printReverse() {
        Node temp = head;
        printRev(head);
    }

    private void printRev(Node temp) {
        if (temp.next == null) {
            System.out.println(temp.data);
            return;
        } else {
            printRev(temp.next);
            System.out.println(temp.data);
            return;
        }

    }

    public void addLastWithNext(AnyType item, Node next) {
        if (head == null) addFirst(item);
        else {
            Node<AnyType> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<AnyType>(item, next);
        }
    }

    public AnyType getNthNodeFromEnd(int n) {
        Node<AnyType> main = head;
        Node<AnyType> ref = head;

        if (head.next == null) throw new NoSuchElementException();
        for (int i = 0; i < n; i++) {
            if (ref.next == null) throw new NoSuchElementException("Length of list less than N");
            ref = ref.next;
        }
        if (ref.next == null) return main.data;
        while (ref.next != null) {
            ref = ref.next;
            main = main.next;
        }
        return main.data;
    }

    /* public boolean isLast(Node<AnyType> node) {
         if (node.next == null) return true;
         return false;
     }*/

    public AnyType getMiddle() {
        int count = 0;
        Node<AnyType> tmp = head;
        Node<AnyType> mid = head;

        while (tmp != null) {
            if ((count & 1) == 1) {
                mid = mid.next;
            }
            ++count;
            tmp = tmp.next;
        }
        if (mid != null) return mid.data;
        else throw new NoSuchElementException();
    }

    public AnyType getLast() {
        if (head == null) throw new NoSuchElementException();
        Node<AnyType> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void clear() {
        head = null;
    }

    public boolean contains_Iterative(AnyType x) {
        for (AnyType xx : this) {
            if (xx.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void deleteHead() {
        head = head.next;
    }

    public void print(Node tmp) {
        Iterator it = this.iterator();

        if (tmp == null) return;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println("============");
    }

    public void deleteNode(Node node) {
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;

    }

    public boolean contains_Recursive(AnyType x) {
        return calc_contains_Recursive(head, x);
    }

    private boolean calc_contains_Recursive(Node<AnyType> node, AnyType key) {
        if (node == null) return false;
        if (node.data.equals(key)) return true;
        return calc_contains_Recursive(node.next, key);

    }

    public AnyType get(int pos) {
        if (head == null) throw new IndexOutOfBoundsException();
        Node<AnyType> tmp = head;
        for (int i = 0; i < pos; i++) {
            tmp = tmp.next;
        }
        if (tmp == null) throw new IndexOutOfBoundsException();
        return tmp.data;
    }

    public AnyType getAtIndex(int n) {
        Node<AnyType> tmp = head;
        while (n-- > 0) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Node getNodeAtIndex(int n) {
        Node tmp = head;
        while (n-- > 0) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void swapNodes(AnyType x, AnyType y) {
        if (x.equals(y)) return;
        Node<AnyType> prevX = null, prevY = null;
        Node<AnyType> curX = head, curY = head;
        while (curX != null && curX.data != x) {
            prevX = curX;
            curX = curX.next;
        }
        while (curY != null && curY.data != y) {
            prevY = curY;
            curY = curY.next;
        }
        if (curX == null || curY == null) return;
        if (prevX != null) prevX.next = curY;
        else head = curY;
        if (prevY != null) prevY.next = curX;
        else head = curX;
        Node<AnyType> tmp = curX.next;
        curX.next = curY.next;
        curY.next = tmp;
    }

    public void moveLastNodeToFirst() {
        Node newHead = null;
        Node temp = head;
        Node temp2 = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        newHead = new Node(temp.next.data);
        temp.next = null;
        newHead.next = temp2;
        head = newHead;

    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (Object x : this) {
            buff.append(x + " ");
        }
        return buff.toString();
    }

    public boolean hasCycle() {
        Node A = head;
        if (head.next == null) return false;
        Node B = A.next;
        while (B != null) {
            if (A.equals(B)) {
                return true;
            }
            A = A.next;
            if (B.next == null) return false;
            B = B.next.next;
        }
        return false;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node incoming) {
        head = incoming;

    }

    public void insertAfter(AnyType key, AnyType toInsert) {
        Node<AnyType> tmp = head;
        while (tmp != null && !tmp.data.equals(key)) tmp = tmp.next;
        if (tmp != null) tmp.next = new Node<AnyType>(toInsert, tmp.next);
    }

    public void insertBefore(AnyType key, AnyType toInsert) {
        if (head == null) return;
        if (head.data.equals(key)) {
            addFirst(toInsert);
            return;
        }
        Node<AnyType> prev = null;
        Node<AnyType> cur = head;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            prev.next = new Node<AnyType>(toInsert, cur);
        }

    }

    public void remove(AnyType key) {
        if (head == null) throw new NoSuchElementException("No Such Element");
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<AnyType> cur = head;
        Node<AnyType> prev = null;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) throw new RuntimeException("Cannot Delete");
        prev.next = cur.next;
        cur = null;
    }

    public int getLength_Iterative() {
        if (head == null) return 0;
        Node<AnyType> cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void pairWiseSwap() {
        Node t = head;
        while (t != null && t.next != null) {
            swap(t, t.next);
            t = t.next.next;
        }
    }

    private void swap(Node a, Node b) {
        AnyType temp = (AnyType) a.data;
        temp = (AnyType) a.data;
        a.data = b.data;
        b.data = temp;
    }

    public int getLength_Recursive() {
        return calcLength_Recursive(head);
    }

    private int calcLength_Recursive(Node<AnyType> node) {
        if (node == null) return 0;
        int count = 0;
        return 1 + calcLength_Recursive(node.next);
    }

    public void deleteList() {
        if (head == null) System.out.println("Already null");
        head = null;
        System.out.println("Linked List is Deleted");
    }

    public int count_Iterative(AnyType data) {
        if (isEmpty()) return 0;
        int count = 0;
        Node<AnyType> tmp = head;
        while (tmp != null) {
            if (tmp.data == data) {
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }

    public int count_Recursive(AnyType data) {
        return count_Recursive(head, data);
    }

    private int count_Recursive(Node<AnyType> ref, AnyType target) {
        return ref == null ? 0 : (ref.data == target) ? 1 + count_Recursive(ref.next, target) : 0 + count_Recursive(ref.next, target);
    }

    public void reverse_Iterative() {
        Node prev = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;

    }


    public void reverse_Recursive() {
        reverse_Recursive(head, null);
    }

    private void reverse_Recursive(Node cur, Node prev) {
        if (cur.next == null) {
            head = cur;
            cur.next = prev;
            return;
        }
        Node temp = cur.next;
        cur.next = prev;
        reverse_Recursive(temp, cur);
    }

    public void SortedInsert(Node new_node) {
        Node current;
        Node headd = head;
        if (headd == null || ((Integer) headd.data) >= (Integer) new_node.data) {
            new_node.next = headd;
            headd = new_node;
        } else {
            current = headd;
            while (current.next != null && (Integer) current.next.data < (Integer) new_node.data)
                current = current.next;
            new_node.next = current.next;
            current.next = new_node;
        }
        head = headd;
    }

    public static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next = null;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }

        public Node(AnyType data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }


    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> nextNode;

        public LinkedListIterator() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
