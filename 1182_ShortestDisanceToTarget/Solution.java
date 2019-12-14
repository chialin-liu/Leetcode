class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < colors.length; i++){
            int color = colors[i];
            if(!map.containsKey(color)){
                map.put(color, new ArrayList<>());
            }
            List<Integer> list = map.get(color);
            list.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int []query: queries){
            int index = query[0];
            int color = query[1];
            if(!map.containsKey(color)){
                res.add(-1);
            }
            else{
                int finalIndex = getIndex(index, map.get(color));
                res.add(finalIndex);
            }
        }
        return res;
    }
    public int getIndex(int index, List<Integer> list){
        int start = 0;
        int end = list.size() - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) == index){
                return 0;
            }
            else if(list.get(mid) > index){
                end = mid;
            }
            else {
                start = mid;
            }
        }
        int leftDistance = Math.abs(list.get(start) - index);
        int rightDistance = Math.abs(list.get(end) - index);
        if(leftDistance < rightDistance){
            return leftDistance;
        }
        else{
            return rightDistance;
        }
    }
}
