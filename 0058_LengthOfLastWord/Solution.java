class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        String [] res = s.split(" ");
        if(res.length >= 1){
            return res[res.length - 1].length();
        }
        else{
            return 0;
        }
        
    }
}
