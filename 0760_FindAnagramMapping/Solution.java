class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(int num: B){
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            List<Integer> list = map.get(num);
            list.add(index);
            index++;
        }
        int []res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                List<Integer> list = map.get(A[i]);
                res[i] = list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        return res;
    }
}
