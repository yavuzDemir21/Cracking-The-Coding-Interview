package linkedlists;

import structures.ListNode;

/*
Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a
loop in the linked list.
*/
public class Question8 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        ListNode loop = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(6);
        head = head.next;
        head.next = loop;
        // 1->4->5->2->3->6->5
        ListNode result = loopDetection(test);
        System.out.println(result.val);
    }

    private static ListNode loopDetection(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(slow != fast);

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
