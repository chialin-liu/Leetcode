class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){
            if(!stack.isEmpty()){
                boolean broken = false;
                while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                    if(stack.peek() > Math.abs(asteroid)){
                        broken = true;
                        break;
                    }
                    else if(stack.peek() == Math.abs(asteroid)){
                        broken = true;
                        stack.pop();
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
                if(broken == false){
                    stack.push(asteroid);
                }
            }
            else{
                stack.push(asteroid);
            }
        }
        int []res = new int[stack.size()];
        int size = stack.size();
        while(!stack.isEmpty()){
            res[size - 1] = stack.pop();
            size--;
        }
        return res;
    }
}
