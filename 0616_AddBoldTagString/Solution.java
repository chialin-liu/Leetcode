class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean []res = new boolean [s.length()];
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(String cur: dict){
                if(s.startsWith(cur, i)){
                    end = Math.max(end, i + cur.length());
                }
            }
            res[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!res[i]){
                sb.append(s.charAt(i));
                continue;
            }
            else{
                int j = i;
                while(j < s.length() && res[j]){
                    j++;
                }
                sb.append("<b>"+s.substring(i, j)+"</b>");
                i = j - 1;
            }
        }
        return sb.toString();
    }
}
