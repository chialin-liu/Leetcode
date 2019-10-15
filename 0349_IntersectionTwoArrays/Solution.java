class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int [] {};
        Set<Integer> set = new HashSet<>();
        Set<Integer> setAll = new HashSet<>();
        for(int i: nums2){
            set.add((Integer) i);
        }
        int count = 0;
        for(int i: nums1){
            if(set.contains(i)){
                setAll.add((Integer) i);
            }
        }
        int [] res = new int [setAll.size()];
        for(Integer i: setAll){
            res[count] = (int) i;
            count++;
        }
        return res;
        
    }
}
