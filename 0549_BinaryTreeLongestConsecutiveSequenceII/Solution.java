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
    int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int []left = dfs(root.left);
        int []right = dfs(root.right);
        int inc = 1;
        int dec = 1;
        if(root.left != null){
            if(root.val == root.left.val + 1){
                dec += left[1];
            }
            else if(root.val + 1 == root.left.val){
                inc += left[0];
            }
        }
        if(root.right != null){
            if(root.val == root.right.val + 1){
                dec = Math.max(dec, right[1] + 1);
            }
            else if(root.val + 1 == root.right.val){
                inc = Math.max(inc, right[0] + 1);
            }
        }
        max = Math.max(max, inc + dec - 1);
        return new int[]{inc, dec};
        
    }
}
