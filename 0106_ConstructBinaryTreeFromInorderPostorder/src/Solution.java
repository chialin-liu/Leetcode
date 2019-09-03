//import javax.swing.tree.TreeNode;


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
   * @param inorder: A list of integers that inorder traversal of a tree
   * @param postorder: A list of integers that postorder traversal of a tree
   * @return: Root of a tree
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // write your code here
    int n = inorder.length ;
    if(n == 0) return null;

    int value = postorder[n - 1];
    TreeNode root = new TreeNode(value);

    int rootIndex = 0;
    for(int i = 0; i < n; i++){
      if(inorder[i] == value){
        rootIndex = i;
        break;
      }
    }
    int []leftInorder = new int[rootIndex];
    int []leftPostorder = new int[rootIndex];
    int []rightInorder = new int[n - rootIndex - 1];
    int []rightPostorder = new int[n - rootIndex - 1];
    for(int i = 0; i < rootIndex; i++){
      leftInorder[i] = inorder[i];
    }
    for(int i = 0; i < rootIndex; i++){
      leftPostorder[i] = postorder[i];
    }
    for(int i = rootIndex, j = 0; i < n - 1; i++, j++){
      rightPostorder[j] = postorder[i];
    }
    for(int i = rootIndex + 1, j = 0; i < n; i++, j++){
      rightInorder[j] = inorder[i];
    }
    root.left = buildTree(leftInorder, leftPostorder);
    root.right = buildTree(rightInorder, rightPostorder);
    return root;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int []inorder = new int []{1,2,3};
    int []postorder = new int []{1,3,2};
    TreeNode root = new TreeNode(0);
    root = sol.buildTree(inorder, postorder);
    System.out.println(root);
  }
}