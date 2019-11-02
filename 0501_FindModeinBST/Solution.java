/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{ 
    Map<Integer, Integer> map;
    int max;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        max = 0;
        helper(root);
        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            int val = map.get(key);
            if(val == max){
                list.add(key);
            }
        }
        int [] res = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int count = map.get(root.val);
        max = Math.max(count, max);
        helper(root.left);
        helper(root.right);
    }
}
