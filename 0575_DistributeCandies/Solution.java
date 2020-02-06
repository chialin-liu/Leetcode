class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int c: candies){
            set.add(c);
        }
        int sister = candies.length / 2;
        if(set.size() >= sister){
            return sister;
        }
        else{
            return set.size();
        }
    }
}
