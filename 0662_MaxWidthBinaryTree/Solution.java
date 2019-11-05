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
    public int widthOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        map.put(root, 1);
        int start = 0;
        int end = 0;
        int max = 0;
        int curWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(i == 0) start = map.get(cur);
                if(i == size - 1) end = map.get(cur);
                if(cur.left != null){
                    map.put(cur.left, 2 * map.get(cur));
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    map.put(cur.right, 2 * map.get(cur) + 1);
                    queue.offer(cur.right);
                }
            }
            curWidth = end - start + 1;
            max = Math.max(max, curWidth);
            
            
        }
        return max;
    }
}
