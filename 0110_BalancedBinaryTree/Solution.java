/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     private int not_balance = -1;
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) return true;
        return maxDepth(root) != not_balance;
    }
    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left == not_balance || right == not_balance){
            return not_balance;
        }
        if(Math.abs(left - right) > 1){
            return not_balance;
        }
        return Math.max(left, right) + 1;
        
    }
}
