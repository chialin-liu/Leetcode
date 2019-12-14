class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                count++;
                continue;
                
            }
            else{
                sb.append(s.charAt(i));
            }
        }
       StringBuilder res = new StringBuilder();
        if(count >= 0){
          for(int i = sb.length() - 1; i >= 0; i--){
            if(count > 0 && sb.charAt(i) == '('){
              count--;
            }
            else{
              res.append(sb.charAt(i));
            }
          }
        }
        return res.reverse().toString();
    }
}
