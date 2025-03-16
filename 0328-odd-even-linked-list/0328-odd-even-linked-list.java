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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head, oddHead = null, odd = null, evenHead = null, even = null;
        while(curr != null){
            if(oddHead == null){
                oddHead = curr;
                odd = curr;
            }else{
                odd.next = curr;
                odd = curr;
            }
            curr = curr.next;
            if(curr == null){
                break;
            }
            if(evenHead == null){
                evenHead = curr;
                even = curr;
            }else{
                even.next = curr;
                even = curr;
            }
            curr = curr.next;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}