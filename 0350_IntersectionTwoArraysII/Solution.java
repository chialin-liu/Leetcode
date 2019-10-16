class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i: nums1){
            if(map.containsKey((Integer) i)){
                int val = map.get((Integer) i);
                val++;
                map.put((Integer) i, val);
            }
            else{
                map.put((Integer) i, 1);
            }
        }
        int count = 0;
        for(int i: nums2){
            if(map.containsKey((Integer) i) && map.get((Integer) i) != 0){
                list.add(i);
                int val = map.get((Integer) i);
                val--;
                map.put((Integer) i, val); 
            }
        }
        int [] res = new int [list.size()];

        for(int i: list){
            res[count] = i;
            count++;
        }
        return res;
    }
}
