class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        int unsatisfied = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] != 1){
                satisfied += customers[i];
            }
            
            if(i < X){
                unsatisfied += (grumpy[i] == 1)? customers[i] : 0;
            }
            else{
                max = Math.max(max, unsatisfied);
                unsatisfied -= (grumpy[i - X] == 1)? customers[i - X]: 0;
                unsatisfied += (grumpy[i] == 1)? customers[i]: 0;
            }
        }
        max = Math.max(max, unsatisfied);
        return satisfied + max;
    }
}
