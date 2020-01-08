/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode parent;
    boolean leftEmpty;
    boolean rightEmpty;
    TreeNode rootTree;
    public CBTInserter(TreeNode root) {
        rootTree = root;
        parent = null;
        leftEmpty = false;
        rightEmpty = false;
    }
    
    public int insert(int v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootTree);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                else{
                    leftEmpty = true;
                    parent = cur;
                    queue.clear();
                    break;
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                else{
                    rightEmpty = true;
                    parent = cur;
                    queue.clear();
                    break;                    
                }
            }
        }        
        TreeNode tempParent = parent;
        if(leftEmpty == true){
            TreeNode newNode = new TreeNode(v);
            parent.left = newNode;
            leftEmpty = false;
        }
        else{
            TreeNode newNode = new TreeNode(v);
            parent.right = newNode;  
            rightEmpty = false;
        }

        return tempParent.val;
    }
    
    public TreeNode get_root() {
        return rootTree;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
