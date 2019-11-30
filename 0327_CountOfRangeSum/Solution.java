class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res;
        long []temp = new long[nums.length + 1];
        long []sum = new long [nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
        res = mergeSort(sum, temp, 0, nums.length, lower, upper);
        return res;
    }
    public int mergeSort(long []nums, long []temp, int left, int right, int lower, int upper){
        if(left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, temp, left, mid, lower, upper) + mergeSort(nums, temp, mid + 1, right, lower, upper);
        count += merge(nums, temp, left, right, lower, upper);
        return count;
    }
    public int merge(long []nums, long []temp, int left, int right, int lower, int upper){
        int mid = left + (right - left) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = left;
        while(leftIndex <= mid && rightIndex <= right){
            if(nums[leftIndex] < nums[rightIndex]){
                temp[tempIndex] = nums[leftIndex];
                tempIndex++;
                leftIndex++;
            }
            else {
                temp[tempIndex] = nums[rightIndex];
                tempIndex++;
                rightIndex++;
            }
        }

        
        while(leftIndex <= mid){
                temp[tempIndex] = nums[leftIndex];
                tempIndex++;
                leftIndex++;
        }
        while(rightIndex <= right){
                temp[tempIndex] = nums[rightIndex];
                tempIndex++;
                rightIndex++;
        }
        int lowerIndex = mid + 1;
        int upperIndex = mid + 1;
        leftIndex = left;
        int count = 0;
        while(leftIndex <= mid){
            while(lowerIndex <= right && nums[lowerIndex] - nums[leftIndex] < lower){
                lowerIndex++;
            }
            while(upperIndex <= right && nums[upperIndex] - nums[leftIndex] <= upper){
                upperIndex++;
            }
            leftIndex++;
            count += upperIndex - lowerIndex;
        }
        
        for(int i = left; i <= right; i++){
            nums[i] = temp[i];
        }
        return count;
    }
}
