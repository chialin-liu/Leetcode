class Solution {
    public boolean checkValidString(String s) {
        int checksum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                checksum++;
            }
            else if(s.charAt(i) == ')'){
                checksum--;
            }
            else{
                checksum++;
            }
            if(checksum < 0){
                return false;
            }
        }
        
        if(checksum == 0){
            return true;
        }
        else{
            checksum = 0;
            for(int i = s.length() - 1; i >= 0; i--){
                if(s.charAt(i) == '('){
                    checksum--;
                }
                else if(s.charAt(i) == ')'){
                    checksum++;
                }
                else{
                    checksum++;
                }
                if(checksum < 0){
                    return false;
                }
            }
            
        }
        return true;
    }
}
