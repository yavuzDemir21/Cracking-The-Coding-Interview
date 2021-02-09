package linkedlists;
/*
Implement an algorithm to find the kth to last element of a singly linked list.
*/


import structures.ListNode;

import static util.LinkListUtils.printList;

public class Question2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);

        printList(test);

        test = kthLastElement(test, 2);
        System.out.println();
        printList(test);
    }

    // 1 2 3 4 5 k=2
    // Assume valid input
    public static ListNode kthLastElement(ListNode head, int k){
        ListNode fast  = head;
        ListNode slow = head;

        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
