/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        List<String> list = new ArrayList<>();
        for(String cur: wordlist){
            list.add(cur);
        }
        List<String> comp = new ArrayList<>(list);
        for(int i = 0; i < 10; i++){
            List<String> newStr = new ArrayList<>();
            if(comp.size() == 0) return;
            String randStr = comp.get(rand.nextInt(comp.size()));
            int masterNumber = master.guess(randStr);
            for(String cur: comp){
                if(!cur.equals(randStr) && getMatchNum(cur, randStr) == masterNumber){
                    newStr.add(cur);
                }
            }
            comp = new ArrayList<>(newStr);
        }
    }
    public int getMatchNum(String str1, String str2){
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
