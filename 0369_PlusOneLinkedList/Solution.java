/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = reverse(head);
        ListNode cur = dummy;
        int carry = 1;
        // int sum = 0;
        while(carry != 0 || cur.next != null){
            if(cur.next != null){
                cur = cur.next;
                cur.val += carry;
                carry = cur.val / 10;
                cur.val = cur.val % 10;
                
            }
            else{
                ListNode newNode = new ListNode(carry);
                cur.next = newNode;
                cur = cur.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
