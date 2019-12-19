class Solution {
    boolean res;
    public boolean judgePoint24(int[] nums) {
        res = false;
        List<Double> list = new ArrayList<>();
        for(int num: nums){
            list.add((double)num);
        }
        helper(list);
        return res;
    }
    public void helper(List<Double> list){
        if(res == true) return;
        if(list.size() == 1){
            if(Math.abs(list.get(0) - 24) < 0.001){
                res = true;
            }
            else{
                res = false;
            }
            return;
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                // if(i == j) continue;
                List<Double> next = new ArrayList<>();
                Double p1 = list.get(i);
                Double p2 = list.get(j);
                next.add(p1 + p2);
                next.add(p1 - p2);
                next.add(p2 - p1);
                next.add(p1 * p2);
                if(Math.abs(p1) > 0.001){
                    next.add(p2 / p1);
                }
                if(Math.abs(p2) > 0.001){
                    next.add(p1 / p2);
                }
                list.remove(i);
                list.remove(j);
                for(Double n: next){
                    list.add(n);
                    helper(list);
                    list.remove(list.size() - 1);
                }
                list.add(j, p2);
                list.add(i, p1);
                
            }
        }
    }
}
