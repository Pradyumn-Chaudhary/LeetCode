/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head, turtle = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(turtle == hare){
                break;
            }
        }
        if(hare == null || hare.next == null)
        return null;
        turtle = head;
        while(turtle != hare){
            turtle = turtle.next;
            hare = hare.next;
        }
        return turtle;
    }
}