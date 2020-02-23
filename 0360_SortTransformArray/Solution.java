class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length - 1;
        int startIndex = (a >= 0)? n: 0;
        int []res = new int[nums.length];
        int i = 0; 
        int j = n;
        while(i <= j){
            if(a >= 0){
                int an1 = getAns(nums[i], a, b, c);
                int an2 = getAns(nums[j], a, b, c);
                if(an1 > an2){
                    res[startIndex] = an1;
                    i++;
                    
                }
                else{
                    res[startIndex] = an2;
                    j--;
                }
                startIndex--;
            }
            else{
                int an1 = getAns(nums[i], a, b, c);
                int an2 = getAns(nums[j], a, b, c);
                if(an1 > an2){
                    res[startIndex] = an2;
                    j--;
                    
                }
                else{
                    res[startIndex] = an1;
                    i++;
                }
                startIndex++;                
            }
        }
        return res;
    }
    public int getAns(int num, int a, int b, int c){
        return num * num * a + num * b + c;
    }
}
