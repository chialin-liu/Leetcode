/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode l1 = head;
        ListNode mid = getMid(head);
        mid.next = reverse(mid.next);
        ListNode p2 = mid.next;
        while(l1 != null && p2 != null){
            if(l1.val != p2.val){
                return false;
            }
            l1 = l1.next;
            p2 = p2.next;
        }
        return true;
    }
    public ListNode getMid(ListNode cur){
        ListNode slow = cur;
        ListNode fast = cur.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
}
