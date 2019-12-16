class Solution {
    Map<String, List<Integer>> map;
    public List<Integer> diffWaysToCompute(String input) {
        map = new HashMap<>();
        List<Integer> res = helper(input);
        return res;
    }
    public List<Integer> helper(String input){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                String s1 = input.substring(0, i);
                String s2 = input.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(s1, helper(s1));
                List<Integer> l2 = map.getOrDefault(s2, helper(s2));
                for(Integer int1: l1){
                    for(Integer int2: l2){
                        if(input.charAt(i) == '+'){
                            res.add(int1 + int2);
                        }
                        else if(input.charAt(i) == '-'){
                            res.add(int1 - int2);
                        }
                        else if(input.charAt(i) == '*'){
                            res.add(int1 * int2);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}
