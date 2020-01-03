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
    public int longestConsecutive(TreeNode root) {
        res = 0;
        if(root == null) return 0;
        dfs(root, 0, root.val);
        return res;
    }
    public void dfs(TreeNode root, int now, int target){
        if(root == null){
            return;
        }
        if(root.val == target){
            now++;
            res = Math.max(res, now);
        }
        else{
            now = 1;
        }
        dfs(root.left, now, root.val + 1);
        dfs(root.right, now, root.val + 1);
    }
}
