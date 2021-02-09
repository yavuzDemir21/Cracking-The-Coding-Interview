package linkedlists;
/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

import structures.ListNode;

import static util.LinkListUtils.printList;

import java.util.HashSet;


public class Question1 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(1);

        printList(test);

        test = removeDups2(test);
        System.out.println();
        printList(test);



    }

    private static ListNode removeDups(ListNode head) {
        if (head == null) return head;

        HashSet<Integer> set = new HashSet<>();

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur.val)) {
                 prev.next = cur.next;
            } else {
                set.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //FOLLOW UP
    private static ListNode removeDups2(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode cur = head;

        while(cur != null){

            ListNode runner = cur;
            while(runner.next != null){
                if(runner.next.val == cur.val){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }

            cur = cur.next;
        }

        return head;
    }

}
