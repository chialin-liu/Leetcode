public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(s == null){
            res.add(new ArrayList<>());
            return res;
        }
        helper(res, new ArrayList<String>(), s);
        return res;
    }
    private void helper(List<List<String>> res, List<String> list, String s){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalin(s.substring(0, i + 1))){
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalin(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
