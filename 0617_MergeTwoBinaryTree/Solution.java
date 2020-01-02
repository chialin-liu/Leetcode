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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = preOrder(t1, t2);
        return root;
    }
    public TreeNode preOrder(TreeNode root1, TreeNode root2){
        TreeNode root = new TreeNode(0);
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 != null && root2 == null){
            root.val = root1.val;
            root.left = preOrder(root1.left, root2);
            root.right = preOrder(root1.right, root2);
        }
        else if(root1 == null && root2 != null){
            root.val = root2.val;
            root.left = preOrder(root1, root2.left);
            root.right = preOrder(root1, root2.right);            
        }
        else{
            root.val = root1.val + root2.val;
            root.left = preOrder(root1.left, root2.left);
            root.right = preOrder(root1.right, root2.right);
        }
        return root;
    }
}
