class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int []f = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            f[i] = i;
        }
        for(List<Integer> pair: pairs){
            int root1 = find(pair.get(0), f);
            int root2 = find(pair.get(1), f);
            if(root1 != root2){
                f[root1] = root2;
            }
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int root = find(i, f);
            if(!map.containsKey(root)){
                map.put(root, new ArrayList<>());
            }
            List<Character> tmp = map.get(root);
            tmp.add(s.charAt(i));
        }
        for(int key: map.keySet()){
            List<Character> tmp = map.get(key);
            Collections.sort(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int root = find(i, f);
            List<Character> tmp = map.get(root);
            char cur = tmp.get(0);
            sb.append(cur);
            tmp.remove(0);
        }
        return sb.toString();
    }
    public int find(int x, int []f){
        while(x != f[x]){
            f[x] = f[f[x]];
            x = f[x];
        }
        return x;
    }
}
