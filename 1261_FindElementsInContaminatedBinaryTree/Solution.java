/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfs(root, set, 0);
    }
    public void dfs(TreeNode root, Set<Integer> set, int value){
        if(root == null) return;
        root.val = value;
        set.add(root.val);
        dfs(root.left, set, root.val * 2 + 1);
        dfs(root.right, set, root.val * 2 + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
