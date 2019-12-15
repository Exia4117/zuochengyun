package basic;

public class LinkedList {
    public static class Node {
        public int val;
        public Node next;

        public Node(int obj) {
            this.val = obj;
        }
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
