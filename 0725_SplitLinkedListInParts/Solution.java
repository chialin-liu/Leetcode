/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode [] res = new ListNode[k];
        ListNode cur = root;
        ListNode pre = null;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        int l = length / k;
        int r = length % k;
        ListNode head = root;
        for(int i = 0; i < k; i++, r--){
            res[i] = head;
            int partLength = l + ((r > 0)? 1: 0);
            for(int j = 0; j < partLength; j++){
                pre = head;
                head = head.next;
            }
            if(pre != null) pre.next = null;
        }
        return res;
    }
}
