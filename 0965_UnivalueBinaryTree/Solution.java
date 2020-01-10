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
    int val;
    boolean res;
    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        res = true;
        preorder(root);
        return res;
    }
    public void preorder(TreeNode root){
        if(root == null) return;
        if(root.val != val){
            res = false;
        }
        preorder(root.left);
        preorder(root.right);
    }
}
