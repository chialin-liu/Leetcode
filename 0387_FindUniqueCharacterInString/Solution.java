class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if(s == null || s.length() == 0) return -1;
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                map.put(s.charAt(i), -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int val: map.values()){
            if(val != -1){
                min = Math.min(val, min);
            }
        }
        return min == Integer.MAX_VALUE? -1 : min;
    }
}
