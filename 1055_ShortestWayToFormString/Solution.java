class Solution {
    public int shortestWay(String source, String target) {
        boolean []map = new boolean[26];
        for(int i = 0; i < source.length(); i++){
            map[source.charAt(i) - 'a'] = true;
        }
        int res = 1;
        for(int i = 0, j = 0; i < target.length(); i++, j++){
            if(map[target.charAt(i) - 'a'] == false){
                return -1;
            }
            while(j < source.length() && source.charAt(j) != target.charAt(i)){
                j++;
            }
            if(j == source.length()){
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }
}
