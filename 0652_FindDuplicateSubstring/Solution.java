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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        postOrder(root, map, res);
        return res;
    }
    public String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> res){
        if(root == null){
            return "null";
        }
        String leftTree = postOrder(root.left, map, res);
        String rightTree = postOrder(root.right, map, res);
        String curTree =  String.valueOf(root.val) + "+" + leftTree + "+" + rightTree;
        if(map.getOrDefault(curTree, 0) == 1){
            res.add(root);
        }
        map.put(curTree, map.getOrDefault(curTree, 0) + 1);
        return curTree;
    }
}
