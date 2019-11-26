class Solution {
    int res;
    public int totalNQueens(int n) {
        res = 0;
        if(n == 0) return 0;
        boolean []col = new boolean[n];
        boolean []d1 = new boolean[2 * n];
        boolean []d2 = new boolean[2 * n];
        helper(col, d1, d2, 0);
        return res;
    }
    public void helper(boolean []col, boolean []d1, boolean []d2, int row){
        if(row == col.length){
            res++;
            return;
        }
        for(int i = 0; i < col.length; i++){
            int id1 = i - row + col.length;
            int id2 = i + row;
            if(col[i] || d1[id1] || d2[id2]) continue;
            col[i] = true;
            d1[id1] = true;
            d2[id2] = true;
            helper(col, d1, d2, row + 1);
            col[i] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
