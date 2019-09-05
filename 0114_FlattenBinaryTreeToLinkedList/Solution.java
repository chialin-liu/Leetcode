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
    public void flatten(TreeNode root) {
        if(root == null)return;
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root == null) return root;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(right != null) return right;
        if(left != null) return left;
        return root;
    }
}
