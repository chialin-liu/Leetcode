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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        root.left = trim(root.left, L, R);
        root.right = trim(root.right, L, R);
        TreeNode newroot = null;
        if(root.val < L){
             newroot = root.right;
            return newroot;
        }
        else if(root.val > R){
             newroot = root.left;
            return newroot;
        }
        else{
            return root;
        }
        
    }
    public TreeNode trim(TreeNode root, int L, int R){
        if(root == null){
            return root;
        }
        root.left = trim(root.left, L, R);
        root.right = trim(root.right, L, R);
        TreeNode newroot = null;
        if(root.val < L){
             newroot = root.right;
            return newroot;
        }
        else if(root.val > R){
             newroot = root.left;
            return newroot;
        }
        else{
            return root;
        }
        
    }
}
