class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return true;
        char [] ss = s.toCharArray();
        char [] tt = t.toCharArray();
        for(char cur: ss){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                val++;
                map.put(cur, val);
            }
            else{
                map.put(cur, 1);
            }
        }
        for(char cur: tt){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                val--;
                map.put(cur, val);
            }
            else{
                map.put(cur, 1);
            }
        }
        for(int val: map.values()){
            if(val != 0) return false;
        }
        return true;
    }
}
