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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null){
            return new TreeNode[]{null, null};
        }
        TreeNode []res = new TreeNode[2];
        if(root.val > V){
            res[1] = root;
            TreeNode []temp = splitBST(root.left, V);
            res[0] = temp[0];
            root.left = temp[1];
        }
        else{
            res[0] = root;
            TreeNode []temp = splitBST(root.right, V);
            root.right = temp[0];
            res[1] = temp[1];
        }
        return res;
    }
}
