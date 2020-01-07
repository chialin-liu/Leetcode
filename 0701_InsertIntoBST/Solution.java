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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return root;
        TreeNode head = root;
        while(true){
            if(root.val < val){
                if(root.right == null){
                    TreeNode cur = new TreeNode(val);
                    root.right = cur;
                    break;
                }
                else{
                    root = root.right;
                }
            }
            else{
                if(root.left == null){
                    TreeNode cur = new TreeNode(val);
                    root.left = cur; 
                    break;
                }
                else{
                    root = root.left;
                }
            }
        }
        return head;
    }
}
