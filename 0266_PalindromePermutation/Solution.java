class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char cur: s.toCharArray()){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int odd = 0;
        int even = 0;
        for(char key: map.keySet()){
            int count = map.get(key);
            if(count % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        if(odd == 1 || odd == 0){
            return true;
        }
        else{
            return false;
        }
        
    }
}
