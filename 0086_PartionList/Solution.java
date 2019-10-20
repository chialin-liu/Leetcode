/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallH = new ListNode(0);
        ListNode small  = smallH;
        ListNode bigH   = new ListNode(0);
        ListNode big    = bigH;
        
        while(head != null){
            ListNode tmp = new ListNode(head.val);
            if(head.val < x){
                small.next = tmp;
                small = small.next;
            }
            else{
                big.next = tmp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigH.next;
        return smallH.next;

    }
}
