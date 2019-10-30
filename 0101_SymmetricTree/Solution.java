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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return true;
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode cur2 = queue.poll();
            if(cur == null && cur2 == null) continue;
            if(cur == null && cur2 != null) return false;
            if(cur != null && cur2 == null) return false;
            if(cur.val != cur2.val) return false;
            queue.offer(cur.left);
            queue.offer(cur2.right);
            queue.offer(cur.right);
            queue.offer(cur2.left);
        }
        return true;
    }
}
