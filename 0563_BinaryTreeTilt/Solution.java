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
    public int findTilt(TreeNode root) {
        res = 0;
        int tilt = dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        res += Math.abs(leftSum - rightSum);
        return leftSum + root.val + rightSum;
    }
}
