package basic;


public class Code_12_SmallerEqualBigger {


    public static LinkedList.Node listPartition1(LinkedList.Node head, int num) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        LinkedList.Node p = head;

        while (p != null) {
            count++;
            p = p.next;
        }

        int[] arr = new int[count];

        p = head;
        int i = 0;
        while (p != null) {
            arr[i] = p.val;
            p = p.next;
            i++;
        }

        arrPartition(arr, num);

        p = head;
        i = 0;
        while (p != null) {
            p.val = arr[i];
            p = p.next;
            i++;
        }
        return head;
    }

    public static void arrPartition(int[] arr, int pivot) {
        int less = -1;
        int more = arr.length - 1;
        int index = 0;
        while (index < more) {
            if (arr[index] < pivot) {
                swap(arr, ++less, index++);
            } else if (arr[index] > pivot) {
                swap(arr, more--, index);
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        if (arr[a] == arr[b]) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static LinkedList.Node listPartition2(LinkedList.Node head, int num) {
        if(head == null ||head.next == null){
            return head;
        }

        LinkedList.Node lessHead = null;
        LinkedList.Node lessEnd = null;
        LinkedList.Node equalHead = null;
        LinkedList.Node equalEnd = null;
        LinkedList.Node moreHead = null;
        LinkedList.Node moreEnd = null;
        LinkedList.Node next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < num) {
                if (lessHead == null) {
                    lessHead = head;
                    lessEnd = head;
                } else {
                    lessEnd.next = head;
                    lessEnd = lessEnd.next;
                }
            } else if (head.val > num) {
                if (moreHead == null) {
                    moreHead = head;
                    moreEnd = head;
                } else {
                    moreEnd.next = head;
                    moreEnd = moreEnd.next;
                }
            } else {
                if (equalHead == null) {
                    equalHead = head;
                    equalEnd = head;
                } else {
                    equalEnd.next = head;
                    equalEnd = equalEnd.next;
                }
            }
            head = next;
        }
        if (lessEnd != null) {
            lessEnd.next = equalHead;
            equalEnd = equalEnd == null ? lessEnd : equalEnd;
        }
        if (equalEnd != null) {
            equalEnd.next = moreHead;

        }
        return lessHead != null ? lessHead : equalHead != null ? equalHead : moreHead;

    }

    public static void main(String[] args) {
        LinkedList.Node head1 = new LinkedList.Node(7);
        head1.next = new LinkedList.Node(9);
        head1.next.next = new LinkedList.Node(1);
        head1.next.next.next = new LinkedList.Node(8);
        head1.next.next.next.next = new LinkedList.Node(5);
        head1.next.next.next.next.next = new LinkedList.Node(2);
        head1.next.next.next.next.next.next = new LinkedList.Node(5);
        head1.next.next.next.next.next.next.next = new LinkedList.Node(3);
        head1.next.next.next.next.next.next.next.next = new LinkedList.Node(10);

        LinkedList.printLinkedList(head1);
//        head1 = listPartition1(head1, 5);
        head1 = listPartition2(head1, 0);
        LinkedList.printLinkedList(head1);

    }
}
