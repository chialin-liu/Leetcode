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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }
    public TreeNode buildTree(int []nums, int start, int end){
        if(start > end){
            return null;
        }
        int max = nums[start];
        int idx = start;
        for(int i = start; i <= end; i++){
            int val = nums[i];
            if(val > max){
                idx = i;
                max = nums[idx];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, start, idx - 1);
        root.right = buildTree(nums, idx + 1, end);
        return root;
    }
}
