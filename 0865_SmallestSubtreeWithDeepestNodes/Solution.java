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
    class Pair{
        TreeNode node;
        int depth;
        public Pair(TreeNode root, int d){
            this.node = root;
            this.depth = d;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair res = dfs(root);
        return res.node;
    }
    public Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(null, 0);
        }
        Pair leftP = dfs(root.left);
        Pair rightP = dfs(root.right);
        if(leftP.depth == rightP.depth){
            return new Pair(root, leftP.depth + 1);
        }
        else if(leftP.depth > rightP.depth){
            return new Pair(leftP.node, leftP.depth + 1);
        }
        else{
            return new Pair(rightP.node, rightP.depth + 1);
        }
    }
}
