class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int []patternArr = new int[pattern.length()];
        function(pattern, patternArr);
        List<String> res = new ArrayList<>();
        for(String word: words){
            int []arr = new int[word.length()];
            function(word, arr);
            boolean compare = true;
            for(int i = 0; i < word.length(); i++){
                if(arr[i] != patternArr[i]){
                    compare = false;
                    break;
                }
            }
            if(compare == true){
                res.add(word);
            }
        }
        return res;
    }
    public void function(String target, int []arr){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length(); i++){
            if(!map.containsKey(target.charAt(i))){
                map.put(target.charAt(i), map.size());
            }
            arr[i] = map.get(target.charAt(i));
        }
    }
}
