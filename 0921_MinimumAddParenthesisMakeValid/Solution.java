class Solution {
    public int minAddToMakeValid(String s) {
        
        char []cur = s.toCharArray();
        int count = 0;
        int res = 0;
        for(int i = 0; i < cur.length; i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                
                res += Math.abs(count);
                count = 0;
            }
        }
        res += count;
        return res;
    }
}
