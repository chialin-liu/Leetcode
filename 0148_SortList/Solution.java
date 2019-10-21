/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(next));
    }
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(a != null && b != null){
            if(a.val <= b.val){
                cur.next = a;
                a = a.next;
            }
            else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a != null) cur.next = a;
        else cur.next = b;
        return dummy.next;
    }
}
