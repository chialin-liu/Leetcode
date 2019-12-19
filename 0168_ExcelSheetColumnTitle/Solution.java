class Solution {
    public String convertToTitle(int n) {
        char []arr = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String res = "";
        int target = n - 1;
        while(target >= 0){
            res = arr[target % 26] + res;
            target /= 26;
            target--;
        }
        return res;
    }
}
