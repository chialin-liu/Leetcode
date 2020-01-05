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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        traverse(root1, root1List);
        traverse(root2, root2List);
        if(root1List.size() != root2List.size()){
            return false;
        }
        for(int i = 0; i < root1List.size(); i++){
            if(root1List.get(i) != root2List.get(i)){
                return false;
            }
        }
        return true;
    }
    public void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
    }
}
