public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
     private String[] mapping= new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }
    private void helper(List<String> res, String digits, String list, int index){
        if(list.length() == digits.length()){
            res.add(list);
            return;
        }
        String letter = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letter.length(); i++){
            helper(res, digits, list + letter.charAt(i), index + 1);
        }
    }
}
