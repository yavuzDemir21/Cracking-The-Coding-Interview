package util;

import structures.ListNode;

public class LinkListUtils {

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}


