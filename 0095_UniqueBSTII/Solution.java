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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<>();
        List<TreeNode> res = helper(1, n);
        return res;
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
        }
        for(int idx = start; idx <= end; idx++){
            List<TreeNode> left = helper(start, idx - 1);
            List<TreeNode> right = helper(idx + 1, end);
            
            for(TreeNode leftNode: left){
                for(TreeNode rightNode: right){
                    TreeNode root = new TreeNode(idx);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
