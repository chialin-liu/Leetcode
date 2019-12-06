class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return false;
        int count = 0;
        for(int a: data){
            if(count == 0){
                if((a >> 5) == 0b110) count = 1;
                else if((a >> 4) == 0b1110) count = 2;
                else if((a >> 3) == 0b11110) count = 3;
                else if((a >> 7) != 0) return false;
            }
            else{
                if((a >> 6) == 0b10) count--;
                else return false;
            }
        }
        return count == 0;
    }
}
