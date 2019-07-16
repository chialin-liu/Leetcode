import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
  class TreeNode {
      int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();

    if(root == null){
      return results;
    }
    Queue<TreeNode>queue = new LinkedList<>();
    queue.add(root);
    TreeNode newNode = new TreeNode(0) ;
    while(!queue.isEmpty()){
      int size = queue.size();
      List<Integer> subset = new ArrayList<>();
      for(int i = 0; i < size; i++) {
        newNode = queue.poll();
        if(newNode.left!=null){
          queue.add(newNode.left);
        }
        if(newNode.right!=null)
        queue.add(newNode.right);
        subset.add(newNode.val);
      }
      results.add(subset);
    }
    return results;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    TreeNode root = new TreeNode(3);
    TreeNode A1 = new TreeNode(9);
    TreeNode A2 = new TreeNode(20);
    TreeNode B1 = new TreeNode(15);
    TreeNode B2 = new TreeNode(7);
    root.left = A1;
    root.right = A2;
    A2.left = B1;
    A2.right = B2;
    List<List<Integer>> results = new ArrayList<>();

    results = sol.levelOrder(root);
    for(List<Integer> subset:results){
      for(int i = 0; i < subset.size(); i++){
        System.out.println(subset.get(i));
      }
//      System.out.println("");

    }

  }
}
