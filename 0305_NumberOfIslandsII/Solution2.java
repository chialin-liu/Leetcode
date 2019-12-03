class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length == 0) return res;
        int []father = new int [m * n];
        for(int i = 0; i < m * n; i++){
            father[i] = -1;
        }
        int count = 0;
        int [][]dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int []pos: positions){
            int cur = pos[0] * n + pos[1];
            if(father[cur] != -1){
                res.add(count);
                continue;
            }
            count++;
            father[cur] = cur;
            for(int []direction: dir){
                int newPosX = pos[0] + direction[0];
                int newPosY = pos[1] + direction[1];
                int newPos = newPosX * n + newPosY;
                if(newPosX < 0 || newPosY < 0 || newPosX >= m || newPosY >= n || father[newPos] == -1) continue;
                int rootNew = find(newPos, father);
                int rootCur = find(cur, father);
                if(rootCur != rootNew){
                    father[rootCur] = rootNew;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
        
    }
    public int find(int x, int []father){
        int j = x;
        while(j != father[j]){
            j = father[j];
        }
        int jx;
        while(x != j){
            jx = father[x];
            father[jx] = j;
            x = jx;
        }
        return x;
    }
}
