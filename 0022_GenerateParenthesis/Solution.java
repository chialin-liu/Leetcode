public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        helper(res, "", n, n);
        return res;
    }
    private void helper(List<String> res, String cur, int left, int right ){
        if(left > right) return;
        if(left == 0 && right == 0){
            res.add(cur);
            return;
        }
        if(left > 0){
            helper(res, cur + "(", left - 1, right);
        }
        if(right > 0){
            helper(res, cur + ")", left, right - 1);
        }
    }
}
