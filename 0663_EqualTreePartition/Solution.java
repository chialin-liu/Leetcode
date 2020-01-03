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
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = dfs(root, map);
        if(total == 0){
           return map.getOrDefault(0, 0) > 1? true: false;
        }
        else if(total % 2 == 0 && map.getOrDefault(total / 2, 0) > 0){
            return true;
        }
        return false;
    }
    public int dfs(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int leftSum = dfs(root.left, map);
        int rightSum = dfs(root.right, map);
        int curSum = root.val + leftSum + rightSum;
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        return curSum;
    }
}
