class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int []newOrder = new int [26];
        for(int i = 0; i < order.length(); i++){
            newOrder[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++){
            String cur = words[i];
            String before = words[i - 1];
            if(isValid(cur, before, newOrder) == false){
                return false;
            }
        }
        return true;
    }
    public boolean isValid(String cur, String before, int []newOrder){
        int i; 
        int j;
        for(i = 0, j = 0; i < cur.length() && j < before.length(); i++, j++){
            if(cur.charAt(i) != before.charAt(j)){
                if (newOrder[cur.charAt(i) - 'a'] < newOrder[before.charAt(j) - 'a']){
                    return false;
                }
                else{
                    return true;
                }
            }
            
        }
        if(cur.length() < before.length()) {
            return false;
        }
        else{
            return true;
        }
    }
}
