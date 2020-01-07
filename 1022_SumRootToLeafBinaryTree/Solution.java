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
    public int sumRootToLeaf(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQ = new LinkedList<>();
        queue.offer(root);
        sumQ.offer(root.val);
        int total = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                int sum = sumQ.poll();
                if(cur.left == null && cur.right == null){
                    total += sum;
                }
                if(cur.left != null){
                    sumQ.offer(sum * 2 + cur.left.val);
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    sumQ.offer(sum * 2 + cur.right.val);
                    queue.offer(cur.right);
                }
            }
        }
        return total;
    }
}
