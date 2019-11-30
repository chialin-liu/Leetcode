class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // if(s == null || s.length() == 0) return res;
        helper(res, s, 0, 0, new char[]{'(',')'});
        return res;
    }
    public void helper(List<String> res, String s, int lastI, int lastJ, char []pair){
        int count  = 0;
        for(int i = lastI; i < s.length(); i++){
            if(s.charAt(i) == pair[0]) count++;
            else if (s.charAt(i) == pair[1]){
                count--;
            }
            if(count >= 0) continue;
            for(int j = lastJ; j <= i; j++){
                if(s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])){
                  helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);  
                }
                
            }
            return ;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(pair[0] == '('){
            helper(res, reverse, 0, 0, new char[]{')', '('});
        }
        else{
            res.add(reverse);
        }
    }
}
