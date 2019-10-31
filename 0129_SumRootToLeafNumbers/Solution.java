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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        int sum = helper(root, 0);
        return sum;
    }
    public int helper(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }
        int left = helper(root.left, root.val + sum * 10);
        int right = helper(root.right, root.val + sum * 10);
        return left + right;
    }
}
