class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});
            }
            else{
                int []arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
                
            }
        }
        int degree = 0;
        int len = 0;
        for(int key: map.keySet()){
            if(map.get(key)[0] > degree){
                degree = map.get(key)[0];
                len = map.get(key)[2] - map.get(key)[1] + 1;
            }
            else if(map.get(key)[0] == degree){
                len = Math.min(len, map.get(key)[2] - map.get(key)[1] + 1);
            }
        }
        return len;
    }
}
