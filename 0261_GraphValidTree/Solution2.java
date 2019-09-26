public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
     private int [] father;
     private int count;
     public int find (int x, int [] f){
         while(x != f[x]){
             x = f[x];
         }
         return x;
     }
     public void union(int a, int b){
         int rootA = find(a, father);
         int rootB = find(b, father);
         if(rootA != rootB){
             father[rootA] = rootB;
             count--;
         }
     }
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges.length != n - 1) return false;
        father = new int [n + 1];
        for(int i = 1; i <= n; i++){
            father[i] = i;
        }
        count = n;
        for(int i = 0; i < edges.length; i++){
            int left = edges[i][1];
            int right = edges[i][0];
            union(left, right);
        }
        
        if(count == 1) return true;
        else return false;
    }
}
