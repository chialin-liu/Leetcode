class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - 0)){
                res = Math.max(res, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return res;
    }
}
