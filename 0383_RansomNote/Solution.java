class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character cur : ransomNote.toCharArray()){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                val++;
                map.put(cur, val);
            }
            else{
                map.put(cur, 1);
            }
        }
        for(Character cur: magazine.toCharArray()){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                if(val == 0) continue;
                val--;
                map.put(cur, val);
            }
        }
        for(int val: map.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
