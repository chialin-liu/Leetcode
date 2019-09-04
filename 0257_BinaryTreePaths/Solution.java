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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, root, "");
        return res;
    }
    public void helper(List<String> res, TreeNode node, String path){
        if(node.left == null && node.right == null){
            res.add(path + node.val);
        }
        if(node.left != null){
            helper(res, node.left, path + node.val + "->");
        }
        if(node.right != null){
            helper(res, node.right, path + node.val + "->");
        }
    }
}
