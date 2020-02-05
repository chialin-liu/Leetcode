class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, new Comparator<String>(){
           public int compare(String s1, String s2){
               return s1.length() - s2.length();
           } 
        });
        int res = 0;
        for(String word: words){
            int best = 0;
            for(int i = 0; i < word.length(); i++){
                String pre = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, map.getOrDefault(pre, 0) + 1);
            }
            map.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}
