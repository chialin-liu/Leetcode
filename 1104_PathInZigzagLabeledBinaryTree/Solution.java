class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 1;
        while(label > (int) Math.pow(2, level) - 1){
            level++;
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        int min = 0;
        while(level > 0){
 
            if(level % 2 == 0){
                max = (int) Math.pow(2, level) - 1;
                min = (int) Math.pow(2, level - 1);                 
                res.add(label);
                label = (max + min - label) / 2;
                level--;
            }
            else{
                res.add(label);
                level--;
                max = (int) Math.pow(2, level) - 1;
                min = (int) Math.pow(2, level - 1);                  
                label = max + min - label / 2 ;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
