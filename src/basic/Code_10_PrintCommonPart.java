package basic;

public class Code_10_PrintCommonPart {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
            next = null;
        }
    }

    public static void CommonPart(Node head1,Node head2){
        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                head1 = head1.next;
            }else if(head2.value < head1.value){
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);

        Node head2 = new Node(-3);
        head2.next = new Node(-2);
        head2.next.next = new Node(-1);
        head2.next.next.next = new Node(1);
        head2.next.next.next.next = new Node(3);
        head2.next.next.next.next.next = new Node(4);
        head2.next.next.next.next.next.next = new Node(6);

        CommonPart(head1,head2);


    }
}
