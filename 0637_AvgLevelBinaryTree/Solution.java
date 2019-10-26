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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double avg = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                avg += cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            avg = avg / size;
            res.add(avg);
        }
        return res;
    }
}
