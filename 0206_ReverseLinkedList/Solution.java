/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}
