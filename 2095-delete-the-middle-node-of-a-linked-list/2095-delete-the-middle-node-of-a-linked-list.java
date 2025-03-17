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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)
        return null;
        ListNode turtle = head, hare = head;
        while(hare != null && hare.next != null && hare.next.next != null && hare.next.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        turtle.next = turtle.next.next;
        return head;
    }
}