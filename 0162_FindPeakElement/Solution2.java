class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(l == r)
                return l;
            else if (nums[mid] > nums[mid + 1])
                r = mid ;
            else
                l = mid + 1;
        }
        return l;
    }
}
