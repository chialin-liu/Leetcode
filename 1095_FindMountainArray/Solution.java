/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = 0;
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(mountainArr.get(end) > mountainArr.get(start)){
            peak = end;
        }
        else{
            peak = start;
        }
        
        start = 0;
        end = peak;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(mountainArr.get(start) == target){
            return start;
        }
        else if(mountainArr.get(end) == target){
            return end;
        }
        
        start = peak;
        end = mountainArr.length() - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(mountainArr.get(start) == target){
            return start;
        }
        else if(mountainArr.get(end) == target){
            return end;
        }
        return -1;
    }
}
