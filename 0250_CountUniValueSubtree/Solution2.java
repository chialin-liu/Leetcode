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
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        if(root == null) return res;
        boolean left = isValid(root.left);
        boolean right = isValid(root.right);
        if(left && right){
            if(root.left == null && root.right != null && root.val == root.right.val){
               res++; 
            }
            else if(root.left != null && root.right == null && root.val == root.left.val){
                res++;
            }
            else if(root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val){
                res++;
            }
            else if(root.left == null && root.right == null){
                res++;
            }
        }
        return res;
    }
    public boolean isValid(TreeNode root){
        if(root == null){
            return true;
        }
        boolean leftValid = isValid(root.left);
        boolean rightValid = isValid(root.right);
        if(leftValid && rightValid){
            if(root.left == null && root.right != null && root.val == root.right.val){
                res++; 
                return true;
            }
            else if(root.left != null && root.right == null && root.val == root.left.val){
                res++;
                return true;
            }
            else if(root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val){
                res++;
                return true;
            }
            else if(root.left == null && root.right == null){
                res++;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
