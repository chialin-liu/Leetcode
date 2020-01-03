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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur == null){
                    end = true;
                }
                else{
                    if(end == true){
                        return false;
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                
            }
        }
        return true;
    }
}
