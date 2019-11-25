class Solution {
    public String rearrangeString(String s, int k) {
        int [] count = new int [26];
        int [] valid = new int [26];
        if(s == null || s.length() == 0) return "";
        for(char c: s.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int nextLetter = findNext(count, valid, i);
            if(nextLetter == -1){
                return "";
            }
            sb.append((char)(nextLetter + 'a'));
            count[nextLetter]--;
            valid[nextLetter] = i + k;
        }
        return sb.toString();
        
    }
    public int findNext(int []count, int []valid, int index){
        int max = 0;
        int res = -1;
        for(int i = 0; i < 26; i++){
            if(count[i] > max && valid[i] <= index){
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}
