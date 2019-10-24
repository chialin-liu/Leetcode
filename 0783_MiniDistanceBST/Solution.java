/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        TreeNode cur = root;
        int lastNode = Integer.MAX_VALUE;
        int dist = 0;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            dist = Math.abs(cur.val - lastNode);
            min = Math.min(min, dist);
            lastNode = cur.val;
            cur = cur.right;
        }
        return min;
    }
}
