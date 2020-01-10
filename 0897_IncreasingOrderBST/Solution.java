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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode pre = dummy;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root= stack.pop();
            pre.right = root;
            root.left = null;
            pre = pre.right;
            root = root.right;
        }
        return dummy.right;
    }
}
