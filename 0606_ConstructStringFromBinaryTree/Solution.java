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
    public String tree2str(TreeNode t) {
        String res;
        res = dfs(t);
        return res;
    }
    public String dfs(TreeNode root){
        if(root == null){
            return "";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);
        String leftMod = left;
        String rightMod = right;
        if(left.length() == 0 && right.length() != 0){
            leftMod = "()";
        }
        else if(left.length() != 0){
            leftMod = "(" + left + ")";
        }
        if(right.length() != 0){
            rightMod = "(" + right + ")";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val));
        sb.append(leftMod);
        sb.append(rightMod);
        return sb.toString();
    }
}
