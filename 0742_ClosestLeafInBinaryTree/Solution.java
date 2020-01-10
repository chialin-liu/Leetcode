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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        TreeNode target = dfs(root, k, map);
        queue.offer(target);
        set.add(target.val);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null){
                return cur.val;
            }
            if(cur.left != null){
                if(!set.contains(cur.left.val)){
                    queue.offer(cur.left);
                    set.add(cur.left.val);
                }
            }
            if(cur.right != null){
                if(!set.contains(cur.right.val)){
                    queue.offer(cur.right);
                    set.add(cur.right.val);
                }                
            }
            TreeNode parent = map.getOrDefault(cur, null);
            if(parent != null){
                if(!set.contains(parent.val)){
                    queue.offer(parent);
                }
            }
        }
        return -1;
    }
    public TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> map){
        if(root == null){
            return null;
        }
        if(root.val == k){
            return root;
        }
        TreeNode left = dfs(root.left, k, map);
        if(left != null){
            map.put(root.left, root);
            return left;
        }
        TreeNode right = dfs(root.right, k, map);
        if(right != null){
            map.put(root.right, root);
            return right;
        }
        return null;
        
    }
}
