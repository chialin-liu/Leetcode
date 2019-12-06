class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int index = 1;
        while(index <= n){
            if(index % 3 == 0 && index % 5 == 0){
                res.add("FizzBuzz");
            }
            else if(index % 3 == 0){
                res.add("Fizz");
            }
            else if(index % 5 == 0){
                res.add("Buzz");
            }
            else{
                res.add(String.valueOf(index));
            }
            index++;
        }
        return res;
    }
}
