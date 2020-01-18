class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<String>> map = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        int []f = new int[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            f[i] = i;
        }
        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(!mail.containsKey(email)){
                    mail.put(email, i);
                }
                else{
                    int root1 = find(mail.get(email), f);
                    int root2 = find(i, f);
                    if(root1 != root2){
                        f[root1] = root2;
                    }
                    mail.put(email, root2);
                }
                
                
            }
        }
        for(int i = 0; i < accounts.size(); i++){
            int root = find(i, f);
            if(!map.containsKey(root)){
                map.put(root, new HashSet<>());
            }
            Set<String> set = map.get(root);
            for(int j = 1; j < accounts.get(i).size(); j++){
                set.add(accounts.get(i).get(j));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(int key: map.keySet()){
            Set<String> set = map.get(key);
            List<String> list = new ArrayList<>();
            for(String cur: set){
                list.add(cur);
            }
            Collections.sort(list);
            list.add(0, accounts.get(key).get(0));
            res.add(new ArrayList<>(list));
        }
        return res;
    }
    public int find(int x, int []f){
        while(x != f[x]){
            x = f[x];
        }
        return x;
    }
}
