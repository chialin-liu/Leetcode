class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int []item: items){
            if(!map.containsKey(item[0])){
                map.put(item[0], new ArrayList<>());
            }
            List<Integer> set = map.get(item[0]);
            set.add(item[1]);
        }
        int [][]res = new int[map.size()][2];
        int index = 0;
        for(int key: map.keySet()){
            List<Integer> set = map.get(key);
            int total = 0;
            int count = 0;
            Collections.sort(set);
            Collections.reverse(set);
            for(int num: set){
                if(count == 5) break;
                total += num;
                count++;
            }
            res[index][0] = key;
            res[index][1] = total / count;
            index++;
            
        }
        return res;
    }
}
