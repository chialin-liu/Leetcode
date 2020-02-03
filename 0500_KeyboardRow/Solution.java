class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('S', 1);
        map.put('D', 1);
        map.put('F', 1);
        map.put('G', 1);
        map.put('H', 1);
        map.put('J', 1);
        map.put('K', 1);
        map.put('L', 1);
        
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        map.put('T', 0);
        map.put('Y', 0);
        map.put('U', 0);
        map.put('I', 0);
        map.put('O', 0);
        map.put('P', 0);
        
        map.put('Z', 2);
        map.put('X', 2);
        map.put('C', 2);
        map.put('V', 2);
        map.put('B', 2);
        map.put('N', 2);
        map.put('M', 2);
        
        List<String> ans = new ArrayList<>();
        boolean fail = false;
        for(String word: words){
            String mod = word.toUpperCase();
            char []cur = mod.toCharArray();
            int index = 0;
            int fix = 0;
            fail = false;
            for(int i = 0; i < cur.length; i++){
                if(i == 0){
                    fix = map.get(cur[i]);
                }
                else{
                    if(map.get(cur[i]) != fix){
                        fail = true;
                        break;
                    }
                }
                
            }
            if(!fail){
                ans.add(word);
            }
        }
        String []res = new String[ans.size()];
        int idx = 0;
        for(String word: ans){
            res[idx] = word;
            idx++;
        }
        return res;
    }
}
