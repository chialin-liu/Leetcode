class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        res = helper(n, n);
        return res;
    }
    public List<String> helper(int cur, int max){
        List<String> res = new ArrayList<>();
        if(cur == 0) {
            res.add("");
            return res;
        }
        else if(cur == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> list = helper(cur - 2, max);
        for(String curStr: list){
            if(cur != max){
                res.add("0" + curStr + "0");
            }
            res.add("1" + curStr + "1");
            res.add("6" + curStr + "9");
            res.add("8" + curStr + "8");
            res.add("9" + curStr + "6");
        }
        return res;
    }
}
