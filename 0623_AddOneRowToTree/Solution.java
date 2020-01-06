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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 0){
            return root;
        }
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(level + 1 == d){
                    TreeNode newNodeLeft = new TreeNode(v);
                    TreeNode newNodeRight = new TreeNode(v);
                    newNodeLeft.left = cur.left;
                    cur.left = newNodeLeft;
                    newNodeRight.right = cur.right;
                    cur.right = newNodeRight;
                }
                else{
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
            }
        }
        return root;
    }
}
