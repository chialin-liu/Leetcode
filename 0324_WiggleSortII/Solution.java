class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int [] tmp = new int [n];
        int mid = (n - 1) / 2;
        int index = 0;
        for(int i = 0; i <= mid; i++){
            tmp[index] = nums[mid - i];
            if(index + 1 < n){
                tmp[index + 1] = nums[n - 1 -i];
            }
            index += 2;
        }
        for(int i = 0; i < n; i++){
            nums[i] = tmp[i];
        }
    }
}
