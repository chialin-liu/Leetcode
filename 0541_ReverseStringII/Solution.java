class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String rev;
        for(int i = 0; i < s.length(); i++){
            if(i == 2 * count * k){
                if(i + k <= s.length()){
                     rev = reverse(s.substring(i, i + k));
                }
                else{
                    rev = reverse(s.substring(i));
                }
                sb.append(rev);
                i = i + k - 1;
                count++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public String reverse(String cur){
        StringBuilder sb = new StringBuilder();
        for(int i = cur.length() - 1; i >= 0; i--){
            sb.append(cur.charAt(i));
        }
        return sb.toString();
    }
}

