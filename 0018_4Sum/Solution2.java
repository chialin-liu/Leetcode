class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums, target, 4, 0);
    }
    public List<List<Integer>> ksum(int []nums, int target, int k, int start){
        List<List<Integer>> res = new ArrayList<>();
        if(k == 2){
            int i = start; 
            int j = nums.length - 1;
            while(i < j){
                if(nums[i] + nums[j] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    while(i < j && nums[i] == nums[i + 1]){
                        i++;
                    }
                    while(i < j && nums[j] == nums[j - 1]){
                        j--;
                    }
                    i++;
                    j--;
                }
                else if(nums[i] + nums[j] < target){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        else{
            for(int index = start; index < nums.length - (k - 1); index++){
                
                List<List<Integer>> tmp = ksum(nums, target - nums[index], k - 1, index + 1);
                if(tmp != null){
                    for(List<Integer> t: tmp){
                        t.add(0, nums[index]);
                        res.add(new ArrayList<>(t));
                    }
                }
                while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
                    index++;
                }
            }
        }
        return res;
    }
}
