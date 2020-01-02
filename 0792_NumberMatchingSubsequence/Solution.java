class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if(words == null || words.length == 0 || S.length() == 0 || S == null){
            return 0;
        }
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            set.add(S.charAt(i));
        }
        boolean compare = true;
        for(String word: words){
            compare = true;
            for(int i = 0, j = 0; i < word.length(); i++, j++){
                if(!set.contains(word.charAt(i))) {
                    compare = false;
                    break;
                }
                while(j < S.length() && S.charAt(j) != word.charAt(i)){
                    j++;
                }
                if(j == S.length()){
                    compare = false;
                }
            }
            if(compare == true){
                res++;
            }
        }
        return res;
    }
}
