/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode l1 = dummy;
        ListNode l2 = head;
        while(l2 != null && l2.next != null){
            ListNode startNew = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = startNew;
            l1 = l2;
            l2 = startNew;
        }
        return dummy.next;
    }
}
