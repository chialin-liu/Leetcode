class Solution {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for(int num: nums){
            if(m1 >= num){
                m1 = num;
            }
            else if(m2 >= num){
                m2 = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
