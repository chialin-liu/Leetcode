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
    Set<Integer> set;
    List<TreeNode> list;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new ArrayList<>();
        set = new HashSet<>();
        if(root == null) return list;
        for(int i: to_delete){
            set.add(i);
        }
        helper(root, true);
        return list;
        
    }
    public TreeNode helper(TreeNode root, boolean isRoot){
        if(root == null) return null;
        boolean isDelete = set.contains(root.val)? true: false;
        if(isRoot & !isDelete) list.add(root);
        root.left = helper(root.left, isDelete);
        root.right = helper(root.right, isDelete);
        return isDelete? null : root;
    }
}
