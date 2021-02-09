package linkedlists;


import structures.ListNode;

import static util.LinkListUtils.printList;

/*
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the
intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact
same node (by reference) as the jth node of the second linked list, then they are intersecting.
*/
public class Question7 {
    public static void main(String[] args) {

        ListNode head = new ListNode(6);
        ListNode test = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        ListNode test2 = head2;
        head2.next = new ListNode(9);
        head2 = head2.next;
        head2.next = head;

        ListNode res = intersection(test, test2);

        printList(res);

    }

    private static ListNode intersection(ListNode l1, ListNode l2){
        int len1 = findLength(l1);
        int len2 = findLength(l2);

        ListNode longer, shorter;

        if(len1 > len2){
            longer = l1;
            shorter = l2;
        }else{
            longer = l2;
            shorter = l1;
        }

        int diff = Math.abs(len1-len2);

        while(diff > 0){
            longer = longer.next;
            diff--;
        }

        while(longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;

    }

    private static int findLength(ListNode l1) {
        int sum = 0;
        while(l1 != null){
            l1 = l1.next;
            sum++;
        }
        return sum;
    }

}
