class Solution {
    public String largestNumber(int[] nums) {
        String []str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String st1, String st2){
                String newSt1 = st1 + st2;
                String newSt2 = st2 + st1;
                return newSt2.compareTo(newSt1);
            }
        });
        if(str[0].charAt(0) == '0') return "0";
        StringBuilder res = new StringBuilder();
        for(String st: str){
             res.append(st);
        }
        return res.toString();
    }
}
