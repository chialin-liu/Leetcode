class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> array = new ArrayList<Integer>();

    int left = findLastPositionTarget(arr, x);
    int right = left + 1;
    for(int i = 0; i < k; i++){
      if(isLeftCloser(left, right, arr, x)){
        array.add(arr[left]);
        left--;
      }
      else{
        array.add(arr[right]);
        right++;
      }
    }
        Collections.sort(array);
    return array;

  }
  boolean isLeftCloser(int left, int right, int A[], int target){
    if(left < 0){
      return false;
    }
    else if(right >= A.length){
      return true;
    }
    else if(target - A[left] > A[right] - target){
      return false;
    }
    else{
      return true;
    }
  }
  public int findLastPositionTarget(int A[], int target){
    int start = 0;
    int end = A.length - 1;
    int mid = 0;
    while(start + 1 < end){
      mid = start + (end - start) / 2;
      if(A[mid] == target){
        start = mid;
      }
      else if(A[mid] < target){
        start = mid;
      }
      else {
        end = mid;
      }
    }
    if(A[end] <= target){
      return end;
    }
    else if(A[start] <= target){
      return start;
    }
    return -1;
  }

}
