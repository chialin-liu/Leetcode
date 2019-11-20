class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String a: words){
            map.put(a, index);
            index++;
        }
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if(palin(str1)){
                    String reverseStr2 = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(reverseStr2) && map.get(reverseStr2) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(reverseStr2));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(str2.length() != 0 && palin(str2)){
                    String reverseStr1 = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(reverseStr1) && map.get(reverseStr1) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(reverseStr1));
                        res.add(list);
                    }                    
                }
            }
        }
        return res;
    }
    public boolean palin(String s){
        int left = 0; 
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
