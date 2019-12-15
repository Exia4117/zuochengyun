package basic;

import java.util.HashMap;

public class Code_13_CopyListWithRandom {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }


    }

    //O(n) extra space
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> help = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            help.put(cur, new Node());
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            help.get(cur).val = cur.val;
            help.get(cur).next = help.get(cur.next);
            help.get(cur).random = help.get(cur.random);
            cur = cur.next;
        }
        return help.get(head);
    }

    //no hashmap
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        cur = head;
        Node copy = null;
        while (cur != null) {
            copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node res = head.next;
        Node next = null;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = cur.next == null?null:cur.next.next;
            cur = next;
        }

        return res;


    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        printRandLinkedList(copyListWithRand1(head));
        printRandLinkedList(copyListWithRand2(head));
    }
}