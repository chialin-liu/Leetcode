import java.util.LinkedList;
import java.util.Queue;


 class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }



public class Solution {
  /**
   * This method will be invoked first, you should design your own algorithm
   * to serialize a binary tree which denote by a root node to a string which
   * can be easily deserialized by your own "deserialize" method later.
   */
  public String serialize(TreeNode root) {
    // write your code here
    if(root == null)return "";
    StringBuilder res = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      TreeNode cur = queue.poll();
      if(cur == null){
        res.append("null ");
        continue;
      }else{
        res.append(cur.val+" ");
      }
      queue.offer(cur.left);
      queue.offer(cur.right);
    }
    return res.toString();
  }

  /**
   * This method will be invoked second, the argument data is what exactly
   * you serialized at method "serialize", that means the data is not given by
   * system, it's given by your own serialize method. So the format of data is
   * designed by yourself, and deserialize it here as you serialize it in
   * "serialize" method.
   */
  public TreeNode deserialize(String data) {
    // write your code here
    if(data == "") return null;
    String[] str = data.split(" ");
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(str[0]));
    queue.offer(root);
    for(int i = 1; i < str.length; i++){
      TreeNode cur = queue.poll();
      if(!str[i].equals("null") ){
        cur.left = new TreeNode(Integer.parseInt(str[i]));
        queue.offer(cur.left);
      }
      i = i + 1;
      if(!str[i].equals("null")){
        cur.right = new TreeNode(Integer.parseInt(str[i]));
        queue.offer(cur.right);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
//    sol.deserialize()
  }
}
