class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String l: list1){
            map.put(l, index);
            index++;
        }
        int sum = Integer.MAX_VALUE;
        int candidate = 0;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                if(sum > i + map.get(list2[i])){
                    sum = i + map.get(list2[i]);
                    candidate = map.get(list2[i]);
                }
            }
        }
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int temp = i + map.get(list2[i]);
                if(temp == sum){
                    res.add(list2[i]);
                }
            }
        }
        String []ans = new String[res.size()];
        index = 0;
        for(String str: res){
            ans[index] = str;
            index++;
        }
        return ans;
    }
}
