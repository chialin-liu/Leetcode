class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int start = 0;
        Arrays.sort(nums);
        int maxValue = nums[nums.length - 1];
        int minValue = nums[0];
        
        // for(int i = 0; i < nums.length; i++){
        //     maxValue = Math.max(maxValue, nums[i]);
        //     minValue = Math.min(minValue, nums[i]);
        // }
        int end = maxValue - minValue;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int count = getCount(nums, mid);
            if(count >= k){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(getCount(nums, start) >= k){
            return start;
        }
        else{
            return end;
        }
    }
    public int getCount(int []nums, int mid){
        int distance = 0;
        int count = 0;
        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         distance = Math.abs(nums[i] - nums[j]);
        //         if(distance <= mid){
        //             count++;
        //         }
        //     }
        // }
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > mid){
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
