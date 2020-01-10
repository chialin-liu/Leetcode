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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        else{
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
