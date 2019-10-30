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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum);
    }
    public boolean helper(TreeNode root, int sum){
        
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
