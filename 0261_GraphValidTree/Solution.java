public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    int [] father;
    public int find(int [] father, int x){
        while(father[x] != x){
            x = father[x];
        }
        return x;
    }
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n == 0)return false;
        if(edges.length != n - 1)return false;
        father = new int [n];
        for(int i = 0; i < n; i++){
            father[i] = i;
        }
        for(int [] pair :  edges){
            int rootA = find(father, pair[0]);
            int rootB = find(father, pair[1]);
            if(rootA == rootB)return false;
            father[rootA] = rootB;
        }
        return true;
    }
}
