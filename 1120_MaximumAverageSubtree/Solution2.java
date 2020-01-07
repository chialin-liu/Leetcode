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
    class Pair{
        int sum;
        int num;
        public Pair(int sum, int num){
            this.sum = sum;
            this.num = num;
        }
    }
    double max;
    public double maximumAverageSubtree(TreeNode root) {
        max = 0;
        Pair cur = dfs(root);
        return max;
    }
    public Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        int sum = left.sum + right.sum + root.val;
        int size = (left.num + right.num + 1);
        double avg = (double)sum / size;
        max = Math.max(max, avg);
        return new Pair(sum, size);
    }
}
