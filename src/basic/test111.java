package basic;

public class test111 {
    public static void main(String[] args) {
        LinkedList.Node head1 = new LinkedList.Node(7);
        head1.next = new LinkedList.Node(9);
        head1.next.next = new LinkedList.Node(1);
        head1.next.next.next = new LinkedList.Node(8);
        head1.next.next.next.next = new LinkedList.Node(5);
        head1.next.next.next.next.next = new LinkedList.Node(2);
        head1.next.next.next.next.next.next = new LinkedList.Node(5);
        LinkedList.printLinkedList(head1);
        LinkedList.printLinkedList(head1);
    }
}
