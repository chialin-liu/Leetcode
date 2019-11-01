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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean isSame(TreeNode A, TreeNode B){
        if(A == null && B == null) return true;
        if(A != null && B == null) return false;
        if(A == null && B != null) return false;
        if(A.val != B.val) return false;
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}
