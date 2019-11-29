import java.util.ArrayList;
import java.util.List;

class Solution {
  int []count;
  public List<Integer> countSmaller(int[] nums) {
    int [] temp = new int [nums.length];
    int [] index = new int [nums.length];
    List<Integer> res = new ArrayList<>();
    if(nums == null || nums.length == 0) return res;
    count = new int [nums.length];
    for(int i = 0; i < index.length; i++){
      index[i] = i;
    }
    mergeSort(nums, 0, nums.length - 1, temp, index);
    for(int i = 0; i < nums.length; i++){
      res.add(count[i]);
    }
    return res;
  }
  public void mergeSort(int []nums, int left, int right, int []temp, int []index){
    if(left >= right) return;
    int mid = left + (right - left) / 2;
    mergeSort(nums, left, mid, temp, index);
    mergeSort(nums, mid + 1, right, temp, index);
    merge(nums, left, right, temp, index);
  }
  public void merge(int []nums, int left, int right, int []temp, int []index){
    int mid = left + (right - left) / 2;
    int leftIndex = left;
    int rightIndex = mid + 1;
    int rightCount = 0;
    int []newIndex = new int [right - left + 1];
    int sortIndex = 0;
    int tempIndex = left;
    while(leftIndex <= mid && rightIndex <= right){
      if(nums[leftIndex] > nums[rightIndex]){
        rightCount++;
        temp[tempIndex] = nums[rightIndex];
        newIndex[sortIndex] = index[rightIndex];
        rightIndex++;
        sortIndex++;
        tempIndex++;
      }
      else{
        count[index[leftIndex]] += rightCount;
        temp[tempIndex] = nums[leftIndex];
        newIndex[sortIndex] = index[leftIndex];
        leftIndex++;
        sortIndex++;
        tempIndex++;

      }
    }
    while(leftIndex <= mid){
      count[index[leftIndex]] += rightCount;
      temp[tempIndex] = nums[leftIndex];
      newIndex[sortIndex] = index[leftIndex];
      leftIndex++;
      sortIndex++;
      tempIndex++;
    }
    while(rightIndex <= right){
      rightCount++;
      temp[tempIndex] = nums[rightIndex];
      newIndex[sortIndex] = index[rightIndex];
      rightIndex++;
      sortIndex++;
      tempIndex++;
    }
    for(int i = left; i <= right; i++){
      index[i] = newIndex[i - left];
      nums[i] = temp[i];
    }

  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int []arr = new int []{5,2,6,1};
    List<Integer> res = sol.countSmaller(arr);
    System.out.println(res);
  }
}
