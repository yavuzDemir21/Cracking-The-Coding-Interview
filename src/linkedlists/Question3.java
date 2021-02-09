package linkedlists;
/*
Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the
exact middle) of a singly linked list, given only access to that node.
*/


import structures.ListNode;

import static util.LinkListUtils.printList;

public class Question3 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        ListNode target = head.next;
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(6);

        printList(test);

        deleteMiddleNode(target);
        System.out.println();
        printList(test);

    }

    // 1 2 3 4 5 6
    //If head is given and exactly middle is asked
    private static ListNode removeMiddle(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;


        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;

        return head;

    }

    private static void deleteMiddleNode(ListNode node){

        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;

        }
        node.val = node.next.val;
        node.next = null;



    }
}
