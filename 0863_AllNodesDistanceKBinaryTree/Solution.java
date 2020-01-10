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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null || target == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<Integer> visit = new HashSet<>();
        visit.add(target.val);
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildGraph(root, null, map);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                    if(K == 0){
                        res.add(cur.val);
                    }
                for(TreeNode neighbor: map.get(cur)){
                    if(!visit.contains(neighbor.val)){
                        queue.offer(neighbor);
                        visit.add(neighbor.val);
                    }
                }
            }
            K--;
        }
        return res;
    }
    public void buildGraph(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> map){
        if(root == null) return;
        if(!map.containsKey(root)){
            map.put(root, new ArrayList<TreeNode>());
        }
        List<TreeNode> list = map.get(root);
        if(root.left != null) list.add(root.left);
        if(root.right != null) list.add(root.right);
        if(parent != null) list.add(parent);
        
        buildGraph(root.left, root, map);
        buildGraph(root.right, root, map);
    }
}
