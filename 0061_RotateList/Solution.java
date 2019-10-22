/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while(index.next != null){
            len++;
            index = index.next;
        }
        index.next = head;
        for(int i = 1; i < len - k % len; i++){
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
