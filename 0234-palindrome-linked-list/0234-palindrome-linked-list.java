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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        return true;
        Stack<ListNode> s = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            s.push(curr);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            if(s.pop().val != curr.val)
            return false;
            curr = curr.next;
        }
        return true;
    }
}