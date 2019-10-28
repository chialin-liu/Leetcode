/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode list: lists){
            if(list != null){
                queue.offer(list);
            }
            
        }
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null){
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
