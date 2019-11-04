class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            char cur = strs[0].charAt(i);
            for(int index = 1; index < strs.length; index++){
                if(i == strs[index].length() || cur != strs[index].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
