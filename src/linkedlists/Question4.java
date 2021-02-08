package linkedlists;

import util.LinkListUtils.ListNode;

import static util.LinkListUtils.printList;

/*
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
than or equal to x. If x is contained within the list the values of x only need to be after the elements less than x
(see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between
the left and right partitions.
*/
public class Question4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(6);

        printList(test);

        test = partition(test, 4);
        System.out.println();
        printList(test);
    }


    // 1 4 5 2 3 6 k=4
    public static ListNode partition(ListNode head, int k){

        ListNode before = null;
        ListNode beforeHead = before;
        ListNode after = null;
        ListNode afterHead = after;

        while(head != null){
            if(head.val < k){
                before = appendNode(before, head);
                if(beforeHead == null) beforeHead = before;
            }else{
                after = appendNode(after, head);
                if(afterHead == null) afterHead = after;
            }
            head = head.next;
        }

        if(after != null) after.next = null;

        if(beforeHead == null) return afterHead;

        before.next = afterHead;

        return beforeHead;

    }

    private static ListNode appendNode(ListNode current, ListNode node) {
        if(current == null) {
            current = node;
        }else {
            current.next = node;
            current = current.next;
        }
        return current;
    }
}
