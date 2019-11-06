class Solution {
    public int strStr(String haystack, String needle) {
        int init = 0;
        int start = 0;
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            init = 0;
            start = i;
            while(haystack.charAt(start) == needle.charAt(init)){
                
                start++;
                init++;
                if(init == needle.length()){
                    return i;
                }
            }
            
        }
        return -1;
    }
}
