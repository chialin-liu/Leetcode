class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n == 0) return res;
        helper(res, new int [n], 0);
        return res;
    }
    public void helper(List<List<String>> res, int []queen, int pos){
        if(pos == queen.length){
            add(res, queen);
            return;
        }
        for(int i = 0; i < queen.length; i++){
            queen[pos] = i;
            if(isValid(queen, pos)){
                helper(res, queen, pos + 1);
            }
        }
    }
    public void add(List<List<String>> res, int []queen){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < queen.length; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < queen.length; j++){
                if(j == queen[i]){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
            
        }
        res.add(list);
    }
    public boolean isValid(int [] queen, int pos){
        for(int i = 0; i < pos; i++){
            if(queen[i] == queen[pos]) return false;
            else if(Math.abs(i - pos) == Math.abs(queen[i] - queen[pos])) return false;
        }
        return true;
    }
}
