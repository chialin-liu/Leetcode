class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        boolean [] res = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            char target = s.charAt(i);
            for(int j = idx; j < t.length(); t++){
                char candi = t.charAt(j);
                if(target == candi){
                    res[i] = true;
                    idx = j + 1;
                    break;
                }
            }
        }
        
        for(boolean finalRes : res){
            if(finalRes == false) return false;
        }
        return true;
    }
}
