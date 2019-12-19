package basic;

import basic.LinkedList.Node;

import java.util.HashSet;

public class Code_14_FindFirstIntersectNode {

    public static Node getEnterLoopNode1(Node head) {
        HashSet<Node> help = new HashSet<>();

        Node cur = head;
        while (cur != null) {
            if (help.contains(cur)) {
                return cur;
            }
            help.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public static Node getEnterLoopNode2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node noLoopCross(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n1 = 0, n2 = 0;

        while (cur1.next != null) {
            cur1 = cur1.next;
            n1++;
        }

        while (cur2.next != null) {
            cur2 = cur2.next;
            n2++;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n1 > n2 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        for (int i = 0; i < Math.abs(n1 - n2); i++) {
            cur1 = cur1.next;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static void main(String[] args) {
// 1->2->3->4->5->6->7->4...
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        System.out.println(getEnterLoopNode1(head1));
        System.out.println(getEnterLoopNode2(head1));

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(7);
        System.out.println(getEnterLoopNode1(head2));
        System.out.println(getEnterLoopNode2(head2));

        // 1->2->3->4->5->6->7->null
        Node head3 =new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);
        head3.next.next.next.next.next = head2.next.next.next;
        LinkedList.printLinkedList(head3);
        LinkedList.printLinkedList(head2);
        System.out.println(noLoopCross(head3,head2).val);



    }
}
