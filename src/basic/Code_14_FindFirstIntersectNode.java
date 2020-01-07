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

//    public static Node noLoopCross(Node head1, Node head2) {
//        if (head1 == null || head2 == null) {
//            return null;
//        }
//
//        Node cur1 = head1;
//        Node cur2 = head2;
//        int n1 = 0, n2 = 0;
//
//        while (cur1.next != null) {
//            cur1 = cur1.next;
//            n1++;
//        }
//
//        while (cur2.next != null) {
//            cur2 = cur2.next;
//            n2++;
//        }
//
//        if (cur1 != cur2) {
//            return null;
//        }
//
//        cur1 = n1 > n2 ? head1 : head2;
//        cur2 = cur1 == head1 ? head2 : head1;
//        for (int i = 0; i < Math.abs(n1 - n2); i++) {
//            cur1 = cur1.next;
//        }
//
//        while (cur1 != cur2) {
//            cur1 = cur1.next;
//            cur2 = cur2.next;
//        }
//        return cur1;
//    }

    public static Node noLoop(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;
        int count = 0;  //两个链表的长度差
        while (a.next != null) {
            count++;
            a = a.next;
        }
        while (b.next != null) {
            count--;
            b = b.next;
        }
        if (a != b)
            return null;

        a = count > 0 ? head1 : head2;
        b = a == head1 ? head2 : head1;
        count = Math.abs(count);
        for (int i = 0; i < count; i++) {
            a = a.next;
        }

        while (a != null && b != null) {
            if (a == b)
                break;
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == loop2) {     //两个链表入环节点一样，说明在入环之前相交
            int count = 0;
            while (cur1.next != loop1) {
                count++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop1) {
                count--;
                cur2 = cur2.next;
            }

            cur1 = count > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            count = Math.abs(count);
            for (int i = 0; i < count; i++) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {     //两个链表入环节点不一样，需要判断两个链表是否相交，如果相交，可以返回任一个入环节点
            Node lo1 = loop1.next;
            while(lo1 != loop1){    //让lo1绕一圈，如果碰到loop2，说明相交
                if(lo1 == loop2){
                    return loop1;
                }
                lo1 = lo1.next;
            }
            return null;
        }
    }

    public static Node getIntersectionNode(Node head1,Node head2){
        if(head1 == null || head2 == null) return null;
        if(getEnterLoopNode2(head1) == null && getEnterLoopNode2(head2) == null){
            return noLoop(head1,head2);
        }else if(getEnterLoopNode2(head1) != null && getEnterLoopNode2(head2) !=null){
            return bothLoop(head1,head2,getEnterLoopNode1(head1),getEnterLoopNode2(head2));
        }else {
            return null;
        }
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
        head1.next.next.next.next.next.next.next = head1.next.next.next; // 7->4

        System.out.println(getEnterLoopNode1(head1));
        System.out.println(getEnterLoopNode2(head1));
        System.out.println("------------------------");

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(7);
        System.out.println(getEnterLoopNode1(head2));
        System.out.println(getEnterLoopNode2(head2));
        System.out.println("-----------------------");

        // 1->2->3->4->5->6->7->null
        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);
        head3.next.next.next.next.next = head2.next.next.next;
        LinkedList.printLinkedList(head3);
        LinkedList.printLinkedList(head2);
        System.out.println(noLoop(head3, head2).val);
        System.out.println("---------------------");

        System.out.println(getIntersectionNode(head2,head3).val);
        System.out.println("-----------------------");

        // 0->9->8->6->4->5->6..

        Node head4 = new Node(0);
        head4.next = new Node(9);
        head4.next.next = new Node(8);
        head4.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectionNode(head4,head1).val);

    }
}
