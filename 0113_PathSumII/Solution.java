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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, new ArrayList<Integer>(), sum);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum){
        List<Integer> list1 = new ArrayList<>();
        list1 = list;
        if(root == null) return;
        list1.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                res.add(new ArrayList<>(list1));
                // res.add(list1);
            }
        }
        helper(root.left, res, list1, sum - root.val);
        helper(root.right, res, list1, sum - root.val);
        list1.remove(list.size() - 1);
    }
}
