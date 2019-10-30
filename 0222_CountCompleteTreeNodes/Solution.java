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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root, true);
        int right = helper(root, false);
        if(left == right){
            return (1 << left) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public int helper(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        return isLeft? helper(root.left, isLeft) + 1: helper(root.right, isLeft) + 1;
    }
}
