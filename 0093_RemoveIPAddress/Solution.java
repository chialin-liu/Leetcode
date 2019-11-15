class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(res, new String(), s, 0, 0);
        return res;
    }
    public void helper(List<String> res, String cur, String s, int index, int count){
        if(count > 4) return;
        if(count == 4 && index == s.length()){
            res.add(cur);
            return;
        }
        for(int i = 1; i < 4; i++){
            if(index + i > s.length()) return;
            String temp = s.substring(index, index + i);
            if(temp.startsWith("0") && temp.length() > 1 || (i == 3 && Integer.valueOf(temp) >= 256)) continue;
            helper(res, cur + temp + (count == 3 ? "": "."), s , index + i, count + 1);
        }
    }
}
