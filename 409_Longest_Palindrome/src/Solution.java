import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int longestPalindrome(String s) {
    if(s==null || s.length()==0){
      return 0;
    }
    Set<Character> words = new HashSet<Character>();
    int count = 0;
    for(int i = 0; i<s.length(); i++){
      if(words.contains(s.charAt(i))){
        count++;
        words.remove(s.charAt(i));
      }
      else{
        words.add(s.charAt(i));
      }
    }
    if(!words.isEmpty())return 2*count+1;
    else return 2*count;
  }
  public static void main(String[] args) {
    System.out.println("Start...");
    Solution sol = new Solution();
    int count = sol.longestPalindrome("abccccdd");
    System.out.println(count);
  }
}
