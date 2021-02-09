package linkedlists;
/*
Implement a function to check if a linked list is a palindrome.
*/

import structures.ListNode;

import java.util.Stack;

import static util.LinkListUtils.printList;

public class Question6 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(4);
        head = head.next;
//        head.next = new ListNode(5);
//        head = head.next;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(1);



        System.out.println(isPalindrome(test));

    }
    // 1 2 3 4 5
    private static boolean isPalindrome(ListNode head){

        Stack<Integer> st = new Stack<>();

        st.push(head.val);
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            st.push(slow.val);
        }

        if(fast.next == null) st.pop();

        slow = slow.next;
        while(slow != null){
            if(st.pop() != slow.val) return false;
            slow = slow.next;
        }

        return true;

    }
}
