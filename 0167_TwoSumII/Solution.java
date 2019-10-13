class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length - 1;
        int [] res = new int [2];
        if(numbers.length == 0 || numbers == null) return res;

        for(int i = 0; i < n; i++){
            int rightIdx = binarySearch(numbers, target - numbers[i], i + 1, n);
            if(rightIdx != -1){
                res[0] = i + 1;
                res[1] = rightIdx + 1;
            }
        }
        return res;
    }
    public int binarySearch(int []nums, int val, int start, int end){
        int left = start;
        int right = end;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == val){
                return mid;
            }
            else if(nums[mid] < val){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
