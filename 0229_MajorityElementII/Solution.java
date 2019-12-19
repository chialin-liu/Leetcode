class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int countA = 0;
        int countB = 0;
        int resA = 0;
        int resB = 0;
        for(int i = 0; i < nums.length; i++){
            if(resA == nums[i]){
                countA++;
            }
            else if(resB == nums[i]){
                countB++;
            }
            else if(countA == 0){
                resA = nums[i];
                countA = 1;
            }
            else if(countB == 0){
                resB = nums[i];
                countB = 1;
            }
            else{
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for(int num: nums){
            if(resA == num) countA++;
            else if(resB == num) countB++;
        }
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        if(countA > (nums.length / 3)){
            list.add(resA);
        }
        if(countB > (nums.length / 3)){
            list.add(resB);
        }
        return list;
        
    }
}
