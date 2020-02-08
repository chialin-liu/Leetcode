class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cur: cpdomains){
            int number = 0;
            for(char digit: cur.toCharArray()){
                if(digit >= '0' && digit <= '9'){
                    number = number * 10 + (digit - '0');
                }
            }
            int startIndex = cur.indexOf(" ");
            String str = cur.substring(startIndex + 1);
            String []split = str.split("\\.");
            int []len = new int[split.length];
            for(int i = 0; i < split.length; i++){
                if(i > 0) len[i] += len[i - 1] + split[i].length() + 1;
                else{
                    len[i] = split[i].length() + 1;
                }
            }
            for(int i = 0; i < split.length; i++){
                StringBuilder sb = new StringBuilder();
                if(i > 0){
                    int removeLength = len[i - 1];
                    sb.append(str.substring(removeLength));
                }
                else{
                    sb.append(str);
                }
                if(map.containsKey(sb.toString())){
                    int count = map.get(sb.toString());
                    
                    map.put(sb.toString(), number + count);
                }
                else{
                    map.put(sb.toString(), number);
                }
                
            }
        }
        List<String> list = new ArrayList<>();
        for(String key: map.keySet()){
            int count = map.get(key);
            list.add(String.valueOf(count) + " " + key);
        }
        return list;
    }
}
