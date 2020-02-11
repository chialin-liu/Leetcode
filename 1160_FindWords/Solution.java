class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> target = new HashMap<>();
        for(char cur: chars.toCharArray()){
            target.put(cur, target.getOrDefault(cur, 0) + 1);
        }
        int res = 0;
        for(String str: words){
            boolean isOk = true;
            Map<Character, Integer> candidate = new HashMap<>();
            for(char cur: str.toCharArray()){
                candidate.put(cur, candidate.getOrDefault(cur, 0) + 1);
            }
            for(char key: candidate.keySet()){
                if(!target.containsKey(key)){
                    isOk = false;
                    break;
                }
                else{
                    int count = candidate.get(key);
                    int compare = target.get(key);
                    if(count <= compare) continue;
                    else{
                        isOk = false;
                        break;
                    }
                }
            }
            if(isOk){
                res += str.length();
            }
        }
        return res;
    }
}
