class Solution {
    public boolean isStrobogrammatic(String num) {
        char []cur = num.toCharArray();
        
        int left = 0;
        int right = cur.length - 1;
        while(left <= right){
            if(cur[left] == '8'){
                if(cur[right] != '8'){
                    return false;
                }
            }
            else if(cur[left] == '0'){
                if(cur[right] != '0'){
                    return false;
                }
            }
            else if(cur[left] == '1'){
                if(cur[right] != '1'){
                    return false;
                }
            }
            else if(cur[left] == '6'){
                if(cur[right] != '9'){
                    return false;
                }
            }
            else if(cur[left] == '9'){
                if(cur[right] != '6'){
                    return false;
                }
            }
            else{
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
