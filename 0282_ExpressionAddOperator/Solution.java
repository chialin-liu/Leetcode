class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, "", 0, 0, target, 0);
        return res;
    }
    public void helper(List<String> res, String num, String curStr, long val, long multi, int target, int pos){
        if(pos == num.length()){
            if(target == val){
                res.add(curStr);
                return;
            }
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long curNum = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(res, num, curStr + curNum, curNum, curNum, target, i + 1);
            }
            else{
                helper(res, num, curStr + '+' + curNum, val + curNum, curNum, target, i + 1);
                helper(res, num, curStr + '-' + curNum, val - curNum, -curNum, target, i + 1);
                helper(res, num, curStr + '*' + curNum, val - multi + multi * curNum, multi * curNum, target, i + 1);
            }
        }
    }
}
