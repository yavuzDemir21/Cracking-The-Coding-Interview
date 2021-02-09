package util;

public class LinkListUtils {
    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}


