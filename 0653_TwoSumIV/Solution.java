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
    boolean res;
    public boolean findTarget(TreeNode root, int k) {
        res = false;
        Set<Integer> set = new HashSet<>();
        inorder(root, k, set);
        return res;
    }
    public void inorder(TreeNode root, int target, Set<Integer> set){
        if(root == null){
            return;
        }
        inorder(root.left, target, set);
        if(set.contains(target - root.val)){
            res = true;
        }
        else{
            set.add(root.val);
        }
        inorder(root.right, target, set);
    }
}
