class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 0;
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        while(end < nums.length){
            while((end < nums.length - 1) && nums[end + 1] - nums[end] == 1){
                end++;
            }
            if(start == end){
                res.add(String.valueOf(nums[start]));
                start++;
                end++;
            }
            else{
                String cur = String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
                res.add(cur);
                end++;
                start = end;
            }
        }
        return res;
    }
}
