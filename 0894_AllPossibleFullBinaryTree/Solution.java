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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N % 2 == 0){
            return new ArrayList<TreeNode>();
        }
        if(N == 1){
            TreeNode newNode = new TreeNode(0);
            res.add(newNode);
            return res;
        }
        for(int i = 1; i < N; i++){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode cur = new TreeNode(0);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
