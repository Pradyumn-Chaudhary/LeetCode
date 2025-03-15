/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode head, ListNode prev){
        if(head == null){
            return prev;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;
        head.next = prev;
        return reverse(temp1, temp);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        return reverse(head,null);
    }
}