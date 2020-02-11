class Solution {
    public String[] expand(String S) {
        Map<Integer, Set<String>> map = new HashMap<>();
        int count = 0;
        int index = 0;
        while(index < S.length()){
            char cur = S.charAt(index);
            if(cur == '{'){
                int last = S.indexOf("}", index);
                String candidate = S.substring(index + 1, last);
                String []arr = candidate.split(",");
                if(!map.containsKey(count)){
                    map.put(count, new HashSet<>());
                }
                Set<String> set = map.get(count);
                for(String can: arr){
                    set.add(can);
                }
                index = last;
                
            }
            else if(cur == '}'){
                count++;
                index++;
            }
            
            else{
                if(!map.containsKey(count)){
                    map.put(count, new HashSet<>());
                }
                Set<String> set = map.get(count);
                set.add(String.valueOf(S.charAt(index)));
                count++;
                index++;
            }
        }
        List<String> list = new ArrayList<>();
        dfs(map, 0, count, list, new StringBuilder());
        
        String[] res = new String[list.size()];
        index = 0;
        for(String cur: list){
            res[index] = cur;
            index++;
        }
        // Arrays.sort(res);
        return res;
    }
    public void dfs(Map<Integer, Set<String>> map, int now, int totalLength, List<String> list, StringBuilder cur){
        if(now == totalLength){
            list.add(cur.toString());
            return;
        }
        Set<String> set = map.get(now);
        for(String neighbor: set){
            cur.append(neighbor);
            dfs(map, now + 1, totalLength, list, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
