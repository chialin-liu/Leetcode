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
    int min;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = null;
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(pre != null){
            min = Math.min(min, Math.abs(pre.val - root.val));
        }
        pre = root;
        inOrder(root.right);
    }
}
