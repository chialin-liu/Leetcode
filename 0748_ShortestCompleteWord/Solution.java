class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        String lic = licensePlate.toLowerCase();
        for(char cur: lic.toCharArray()){
            if(cur >= 'a' && cur <= 'z'){
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            
        }
        boolean isMatch = true;
        List<String> list = new ArrayList<>();
        Map<Character, Integer> temp = new HashMap<>();
        for(String str: words){
            temp = new HashMap<>();
            isMatch = true;
            for(int i = 0; i < str.length(); i++){
                char cur = str.charAt(i);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
            }
            for(char key: map.keySet()){
                int golden = map.get(key);
                int compare = temp.getOrDefault(key, 0);
                if(golden > compare){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                if(min > str.length()){
                    list = new ArrayList<>();
                    min = str.length();
                    list.add(str);
                }
                else if (min == str.length()){
                    list.add(str);
                }
            }
        }
        return list.get(0);
    }
}
