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
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
         sum = 0;
        dfs(root, L, R);
        return sum;
    }
    public void dfs(TreeNode root, int L,int R){
        if(root == null) return;
        dfs(root.left, L, R);
        if(root.val >= L && root.val <= R){
            sum += root.val;
        }
        dfs(root.right, L, R);
        
    }
}
