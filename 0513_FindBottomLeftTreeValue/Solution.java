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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        TreeNode cur = new TreeNode(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                 cur = queue.poll();
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }
        }
        return cur.val;
    }
}
