/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
        private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
     Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        if(lists == null || lists.length == 0) return null;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = cur;
            if(cur.next != null){
                queue.offer(cur.next);
            }
        }
        return dummy.next;
           
    }
}
