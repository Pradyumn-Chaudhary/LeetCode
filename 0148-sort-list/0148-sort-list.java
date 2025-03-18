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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode turtle = head;
        ListNode hare = head.next;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }
        ListNode temp = turtle.next;
        turtle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }

        ListNode temp1 = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp1.next = left;
                left = left.next;
            } else {
                temp1.next = right;
                right = right.next;
            }
            temp1 = temp1.next;
        }

        while (left != null) {
            temp1.next = left;
            left = left.next;
            temp1 = temp1.next;
        }
        while (right != null) {
            temp1.next = right;
            right = right.next;
            temp1 = temp1.next;
        }
        temp1.next = null;
        return head;
    }
}