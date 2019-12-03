class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = n;
        int []father = new int[n];
        for(int i = 0; i < father.length; i++){
            father[i] = i;
        }
        for(int []cur: edges){
            int x = find(cur[0], father);
            int y = find(cur[1], father);
            if(x != y){
                father[x] = y;
                res--;
            }
        }
        return res;
    }
    public int find(int x, int []father){
        int j = x;
        int fx;
        while(j != father[j]){
            j = father[j];
        }
        while(x != father[x]){
            fx = father[x];
            father[fx] = j;
            x = fx;
        }
        return j;
    }
}
