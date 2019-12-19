class Solution {
    public int titleToNumber(String s) {
        char []arr = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char [] res = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < res.length; i++){
            sum = sum * 26;
            for(int index = 0; index < 26; index++){
                if(res[i] == arr[index]){
                   sum += index + 1; 
                }
            }
            
        }
        return sum;
    }
}
