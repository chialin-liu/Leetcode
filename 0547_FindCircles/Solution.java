class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int []father = new int[M.length * M[0].length];
        int []rank = new int[M.length * M[0].length];
        for(int i = 0; i < father.length; i++){
            father[i] = i;
            rank[i] = 1;
        }
        int res = M.length;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    int rootA = find(i, father);
                    int rootB = find(j, father);
                    if(rootA != rootB){
                        if(rank[rootA] > rank[rootB]){
                            father[rootB] = rootA;
                            res--;
                        }
                        else if(rank[rootA] < rank[rootB]){
                            father[rootA] = rootB;
                            res--;
                        }
                        else{
                            father[rootA] = rootB;
                            rank[rootB]++; 
                            res--;
                        }    
                    }
                    
                    // if(rootA != rootB){
                    //     father[rootA] = rootB;
                    //     res--;
                    // }
                }
            }
        }
        return res;
    }
    // public int find(int x, int []father){
    //     int j = x;
    //     while(j != father[j]){
    //         j = father[j];
    //     }
    //     int jx;
    //     while(x != j){
    //         jx = father[x];
    //         father[jx] = j;
    //         x = jx;
    //     }
    //     return j;
    // }
    public int find(int x, int []father){
        if(x != father[x]){
            father[x] = find(father[x], father);
        }
        return father[x];
    }
}
