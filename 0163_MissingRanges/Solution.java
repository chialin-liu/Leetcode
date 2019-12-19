class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
             res.add(getRange(lower, upper));
            return res;
        }
        if(nums[0] > lower){
            res.add(getRange(lower, nums[0] - 1));
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1){
                res.add(getRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if(nums[nums.length - 1] < upper){
            res.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        return res;
        
    }
    public String getRange(int lo, int hi){
        String res = "";
        if(lo == hi){
            res = String.valueOf(lo);
        }
        else{
            res = String.valueOf(lo) + "->" + String.valueOf(hi);
        }
        return res;
    }
}
