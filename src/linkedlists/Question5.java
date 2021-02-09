package linkedlists;


import structures.ListNode;

import static util.LinkListUtils.printList;

/*
You have two numbers represented by a linked list,where each node contains a single digit. The digits are stored in
reverse order,such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns
the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.That is,912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is,
617 + 295. Output:9 ->1 ->2.That is,912.

 */
public class Question5 {
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
        head2.next = new ListNode(5);


        ListNode result = sumLists2(test, test2);
        printList(result);

    }

    private static ListNode sumLists(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode();
        ListNode result = sum;
        int carry = 0;

        while (l1 != null && l2 != null) {

            int cur = l1.val + l2.val + carry;
            carry = cur / 10;
            cur = cur % 10;

            sum.next = new ListNode(cur);

            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            int cur = l1.val + carry;
            carry = cur / 10;
            cur = cur % 10;

            sum.next = new ListNode(cur);

            sum = sum.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int cur = l2.val + carry;
            carry = cur / 10;
            cur = cur % 10;

            sum.next = new ListNode(cur);

            sum = sum.next;
            l2 = l2.next;
        }

        return result.next;
    }

    //FOLLOW UP
    private static ListNode sumLists2(ListNode l1, ListNode l2){
        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        return sumLists(reversedL1, reversedL2);
    }
    // 6->1->7 => 7->1->6
    private static ListNode reverseList(ListNode node){
        ListNode cur = new ListNode();

        while(node != null){
            cur.val = node.val;
            ListNode temp = cur;
            cur = new ListNode();
            cur.next = temp;
            node = node.next;
        }

        return cur.next;
    }
}
