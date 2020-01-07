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
        public Pair(TreeNode cur, int d){
            this.node = cur;
            this.depth = d;
        }
    }
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;
        Pair rootPair = new Pair(root, 0);
        Pair cur = dfs(rootPair);
        return cur.node;
    }
    public Pair dfs(Pair now){
        if(now.node == null){
            return new Pair(null, now.depth);
        }
        Pair leftChild = new Pair(now.node.left, now.depth + 1);
        Pair rightChild = new Pair(now.node.right, now.depth + 1);
        Pair left = dfs(leftChild);
        Pair right = dfs(rightChild);
        if(left.depth == right.depth){
            return new Pair(now.node, left.depth);
            
        }
        return left.depth > right.depth? left: right;
        
    }
}
