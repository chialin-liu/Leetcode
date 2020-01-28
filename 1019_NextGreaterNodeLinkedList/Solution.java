/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int []res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
