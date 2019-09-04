/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
     private TreeNode lastNode;
     private boolean isValid;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        lastNode = null;
        isValid = true;
        inorder(root);
        return isValid;
    }
    public void inorder(TreeNode root){
        if(root == null)return ;
        inorder(root.left);
        if(lastNode != null && lastNode.val >= root.val){
            isValid = false;
            return ;
        }
        lastNode = root;
        inorder(root.right);
    }
}
