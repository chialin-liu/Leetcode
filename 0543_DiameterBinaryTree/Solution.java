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
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        if(root == null) return 0;
        int leftValue = count(root.left);
        int rightValue = count(root.right);
        return Math.max(res, leftValue + rightValue);
    }
    public int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftValue = count(root.left);
        int rightValue = count(root.right);
        res = Math.max(res, leftValue + rightValue);
        return 1 + Math.max(leftValue, rightValue);
    }
}
