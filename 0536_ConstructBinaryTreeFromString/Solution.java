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
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        if(s == null || s.length() == 0){
            return null;
        }
        for(int i = 0; i < s.length(); i++){
            int start = i;
            if(s.charAt(i) == ')'){
                stack.pop();
            }
            else if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-'){
                while(i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-')){
                    i++;
                }
                TreeNode cur = new TreeNode(Integer.valueOf(s.substring(start, i)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null){
                        parent.right = cur;
                    }
                    else{
                        parent.left = cur;
                    }
                }
                stack.push(cur);
                i--;
            }
        }
        return stack.pop();
    }
}
