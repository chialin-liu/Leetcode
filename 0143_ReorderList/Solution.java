/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode temp = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode rever = reverse(slow);
        merge(l1, rever);
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    public void merge(ListNode l1, ListNode l2){
        while(l1 != l2){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if(n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
