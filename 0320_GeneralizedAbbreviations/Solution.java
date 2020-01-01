class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        // StringBuilder sb = new StringBuilder()
        dfs(res, word, "", 0, 0);
        return res;
    }
    public void dfs(List<String> res, String word, String cur, int pos, int count){
        if(pos == word.length()){
            if(count > 0){
                cur += count;
            }
            res.add(cur);
            return;
        }
        String temp ="";
        if(count > 0){
            temp = String.valueOf(count);
        }
        dfs(res, word, cur, pos + 1, count + 1);
        dfs(res, word, cur + ((count > 0)? temp: "") + word.charAt(pos), pos + 1, 0);
    }
}
