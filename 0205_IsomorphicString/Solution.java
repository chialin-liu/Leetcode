class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char [] ss = s.toCharArray();
        char [] tt = t.toCharArray();
        if(ss.length != tt.length) return false;
        for(int i = 0; i < ss.length; i++){
            if(map.containsKey(ss[i])){
                char cur = map.get(ss[i]);
                if(cur != tt[i]){
                    return false;
                }
            }
            else{
                if(map.containsValue(tt[i])){
                    return false;
                }
                else{
                   map.put(ss[i], tt[i]); 
                }
            }
        }
        return true;
    }
}
