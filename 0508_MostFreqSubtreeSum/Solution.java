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
    int max;
    Map<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        max = 0;
        map = new HashMap<>();
        if(root == null) return new int[]{};
        helper(root);
        
        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int [] res = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
        
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int count = map.get(sum);
        max = Math.max(count, max);
        return sum;
    }
}
