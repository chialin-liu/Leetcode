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
    int res;
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        dfs(root, max, min);
        return res;
    }
    public void dfs(TreeNode root, int max, int min){
        if(root == null){
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        res = Math.max(max - min, res);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
