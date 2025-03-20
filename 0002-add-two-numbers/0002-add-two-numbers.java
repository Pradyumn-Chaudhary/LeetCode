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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead, temp1 = l1, temp2 = l2;
        int carry = 0;
        while(temp1 != null && temp2 != null){
            int data = temp1.val + temp2.val + carry;
            carry = data < 10 ? 0 : 1;
            data = data < 10 ? data : data - 10;
            ListNode temp = new ListNode(data);
            dummy.next = temp;
            dummy = temp;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            int data = temp1.val + carry;
            carry = data < 10 ? 0 : 1;
            data = data < 10 ? data : data - 10;
            ListNode temp = new ListNode(data);
            dummy.next = temp;
            dummy = temp;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            int data = temp2.val + carry;
            carry = data < 10 ? 0 : 1;
            data = data < 10 ? data : data - 10;
            ListNode temp = new ListNode(data);
            dummy.next = temp;
            dummy = temp;
            temp2 = temp2.next;
        }
        if(carry == 1){
            ListNode temp = new ListNode(carry);
            dummy.next = temp;
        }
        return dummyHead.next;
    }
}