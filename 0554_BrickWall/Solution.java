class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(List<Integer> list: wall){
            sum = 0;
            for(int i = 0; i < list.size() - 1; i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        return max == Integer.MIN_VALUE? wall.size(): wall.size() - max;
    }
}
