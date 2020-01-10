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
    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        pre = new TreeNode(0);
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        root.val += pre.val;
        pre = root;
        dfs(root.left);
    }
}
