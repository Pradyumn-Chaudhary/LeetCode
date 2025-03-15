/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode hare = head, turtle = head;
        while (hare != null && hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        ListNode prev = null;
        ListNode curr = turtle.next;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;

        ListNode curr1 = curr;
        ListNode curr2 = head;

        while (curr1 != null) {
            if (curr1.val != curr2.val)
                return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
}