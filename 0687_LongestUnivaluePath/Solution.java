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
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        if(root == null) return 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int leftV = 0;
        int rightV = 0;
        if(root.left != null && root.left.val == root.val){
            leftV += left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightV += right + 1;
        }
        res = Math.max(res, leftV + rightV);
        return Math.max(leftV, rightV);
    }
}
