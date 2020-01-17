class Solution {
    public int minimumCost(int N, int[][] connections) {
        int []f = new int [N + 1];
        Arrays.sort(connections, new Comparator<int []>(){
            public int compare(int []a, int []b){
                return a[2] - b[2];
            }
        });
        for(int i = 1; i <= N; i++){
            f[i] = i;
        }
        int total = N;
        int res = 0;
        for(int []connect: connections){
            int root1 = find(connect[0], f);
            int root2 = find(connect[1], f);
            if(root1 != root2){
                f[root1] = root2;
                total--;
                res += connect[2];
            }
        }
        return total == 1? res: -1;
    }
    public int find(int x, int []f){
        while(x != f[x]){
            x = f[x];
        }
        return x;
    }
}
