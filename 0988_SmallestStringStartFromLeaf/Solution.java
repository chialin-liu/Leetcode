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
    String ans;
    public String smallestFromLeaf(TreeNode root) {
        ans = "~";
        dfs(root, new StringBuilder());
        return ans;
    }
    public void dfs(TreeNode root, StringBuilder cur){
        if(root == null){
            return;
        }
        cur.append((char) ('a' + root.val));
        if(root.left == null && root.right == null){
            cur.reverse();
            String str = cur.toString();
            cur.reverse();
            if(str.compareTo(ans) < 0){
                ans = str;
            }
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
        cur.deleteCharAt(cur.length() - 1);
    }
}
