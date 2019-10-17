class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character cur: s.toCharArray()){
            if(map.containsKey(cur)){
                int val = map.get(cur);
                val++;
                map.put(cur, val);
            }
            else{
                map.put(cur, 1);
            }
        }
        char []arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
