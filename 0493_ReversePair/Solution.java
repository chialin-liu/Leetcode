class Solution {
  public int reversePairs(int[] nums) {
    int []temp = new int [nums.length];
    if(nums == null || nums.length == 0) return 0;
    int res = mergeSort(nums, 0, nums.length - 1, temp);
    return res;
  }
  public int mergeSort(int []nums, int left, int right, int [] temp){
    if(left >= right) return 0;
    int mid = left + (right - left) / 2;
    int res = mergeSort(nums, left, mid, temp) + mergeSort(nums, mid + 1, right, temp);
    res += merge(nums, left, right, temp);
    return res;
  }
  public int merge(int []nums, int left, int right, int []temp){
    int mid = left + (right - left) / 2;
    int leftIndex = left;
    int rightIndex = mid + 1;
    int index = left;
    int p = mid + 1;
    int res = 0;
    while(leftIndex <= mid && rightIndex <= right){
      if(nums[leftIndex] < nums[rightIndex]){
        temp[index] = nums[leftIndex];
        index++;
        leftIndex++;
      }
      else{
        temp[index] = nums[rightIndex];
        index++;
        rightIndex++;
      }
    }
    while(leftIndex <= mid){
      temp[index] = nums[leftIndex];
      index++;
      leftIndex++;
    }
    while(rightIndex <= right){
      temp[index] = nums[rightIndex];
      index++;
      rightIndex++;
    }
    leftIndex = left;
    while(leftIndex <= mid){
      while(p <= right && nums[leftIndex] > 2L * nums[p]){
        p++;
      }
      res += p - (mid + 1);
      // p = mid + 1;
      leftIndex++;
    }
    for(int i = left; i <= right; i++){
      nums[i] = temp[i];
    }
    return res;
  }

  // public static void main(String[] args) {
  //   Solution sol = new Solution();
  //   int [] num = new int []{5,4,3,2,1};
  //   int res = sol.reversePairs(num);
  //   System.out.println(res);
  // }
}
