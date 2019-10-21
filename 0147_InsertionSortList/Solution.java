/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }
            else{
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                ListNode pre = dummy;
                while(pre.next.val <= tmp.val){
                    pre = pre.next;
                }
                tmp.next = pre.next;
                pre.next = tmp;
            }
        }
        return dummy.next;
    }
}
