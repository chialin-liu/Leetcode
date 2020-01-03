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
    TreeNode suc;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        pre = null;
        suc = null;
        dfs(root, p);
       
        return suc;
    }
    public void dfs(TreeNode root, TreeNode p){
        if(root == null) return;
        dfs(root.left, p);
        if(pre == p){
            suc = root;
        }
        pre = root;
        dfs(root.right, p);
    }
}
