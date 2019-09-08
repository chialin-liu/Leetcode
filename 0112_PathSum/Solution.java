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
    public boolean hasPathSum(TreeNode root, int sum) {
        TreeNode cur = root;
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.left == null && cur.right == null){
                if(cur.val == sum){
                    return true;
                }
            }    
            if(cur.right != null){
                cur.right.val = cur.val + cur.right.val;
                stack.push(cur.right);
            }
            if(cur.left != null){
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false;
    }
}
