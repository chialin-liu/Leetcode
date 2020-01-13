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
    class Point{
        int size;
        int lower;
        int upper;
        public Point(int s, int l, int u){
            this.size = s;
            this.lower = l;
            this.upper = u;
        }
    }
    int max;
    public int largestBSTSubtree(TreeNode root) {
       max = 0;
        dfs(root);
        return max;
    }
    public Point dfs(TreeNode root){
        if(root == null){
            return new Point(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Point leftTree = dfs(root.left);
        Point rightTree = dfs(root.right);
        if(leftTree.size == -1 || rightTree.size == -1 || root.val <= leftTree.upper || root.val >= rightTree.lower){
            return new Point(-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        int size = leftTree.size + rightTree.size + 1;
        max = Math.max(size, max);
        return new Point(size, Math.min(root.val, leftTree.lower), Math.max(root.val, rightTree.upper));
    }
}
