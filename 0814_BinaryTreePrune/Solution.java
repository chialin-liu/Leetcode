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
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public TreeNode dfs(TreeNode root){
        if(root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(root.left == null && root.right == null){
            if(root.val == 0){
                return null;
            }
            else{
                return root;
            }
        }
        else{
            return root;
        }
    }
}
