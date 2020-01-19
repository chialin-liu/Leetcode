class Solution {
    public int removeStones(int[][] stones) {
        Map<String, String> map = new HashMap<>();
        for(int []stone: stones){
            String coord = String.valueOf(stone[0]) + " " + String.valueOf(stone[1]);
            map.put(coord, coord);
        }
        int total = stones.length;
        int connected = total;
        for(int []stone: stones){
            String str1 = String.valueOf(stone[0]) + " " + String.valueOf(stone[1]);
            for(int []stone2: stones){
                if(stone[0] == stone2[0] || stone[1] == stone2[1]){
                    String str2 = String.valueOf(stone2[0]) + " " + String.valueOf(stone2[1]);
                    String root1 = find(map, str1);
                    String root2 = find(map, str2);
                    if(!root1.equals(root2)){
                        map.put(root1, root2);
                        connected--;
                    }                    
                }

            }
        }
        return total - connected;
    }
    public String find(Map<String, String> map, String cur){
        while(!cur.equals(map.get(cur))){
            cur = map.get(cur);
        }
        return cur;
    }
}
