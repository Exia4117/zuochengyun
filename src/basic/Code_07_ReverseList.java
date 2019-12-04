package basic;

public class Code_07_ReverseList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseLink(Node head){
        Node next = null;
        Node pre = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;
        public DoubleNode(int value){
            this.value = value;
        }
    }

    public static DoubleNode reverseDLink(DoubleNode head){
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkList(Node head){
        Node p = head;
        while(p !=null){
            System.out.print(p.value + " ");
            p=p.next;
        }
        System.out.println(" ");
    }

    public static void printDLinkList(DoubleNode head){
        DoubleNode p = head;
        while(p !=null){
            System.out.print(p.value + " ");
            p=p.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkList(head1);
        head1 = reverseLink(head1);
        printLinkList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDLinkList(head2);
        printDLinkList(reverseDLink(head2));
    }

}
