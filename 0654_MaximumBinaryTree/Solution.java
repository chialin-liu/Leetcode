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
    public TreeNode constructMaximumBinaryTree(int[] A) {
        if(A == null || A.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i <= A.length; i++){
            TreeNode right = (i == A.length)? new TreeNode(Integer.MAX_VALUE): new TreeNode(A[i]);
            while(!stack.isEmpty() && right.val > stack.peek().val){
                TreeNode cur = stack.pop();
                if(stack.isEmpty()){
                    right.left = cur;
                }
                else{
                    TreeNode left = stack.peek();
                    if(left.val > right.val){
                        right.left = cur;
                    }
                    else{
                        left.right = cur;
                    }
                }
                
            }
            stack.push(right);
        }
        return stack.peek().left;       
    }
}
