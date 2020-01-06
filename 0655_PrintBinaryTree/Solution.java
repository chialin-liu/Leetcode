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
    public List<List<String>> printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        int m = level;
        int n = (int) Math.pow(2, level) - 1;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                list.add("");
            }
            res.add(new ArrayList<>(list));
        }
        queue.offer(root);
        Queue<int []> index = new LinkedList<>();
        index.offer(new int[]{0, n - 1});
        level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                int []newArr = index.poll();
                int left = newArr[0];
                int right = newArr[1];
                int mid = left + (right - left) / 2;
                res.get(level).set(mid, String.valueOf(cur.val));
                if(cur.left != null){
                    queue.offer(cur.left);
                    index.offer(new int[]{left, mid - 1});
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    index.offer(new int[]{mid + 1, right});
                }
                
            }
        }
        return res;
    }
}
