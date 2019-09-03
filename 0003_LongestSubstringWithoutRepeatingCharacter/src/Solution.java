import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();

//    while (j < s.length()) {
//      if (!set.contains(s.charAt(j))) {
//        set.add(s.charAt(j));
//        j++;
//        max = Math.max(max, set.size());
//      } else {
//        set.remove(s.charAt(i));
//        i++;
//      }
//    }
    for(i = 0, j = 0; i < s.length(); i++){
      if(set.contains(s.charAt(i))){
        set.remove(s.charAt(j++));
        i--;
      }
      else{
        set.add(s.charAt(i));
        max = Math.max(max, set.size());
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String str = "  -42";
    str = str.trim();
    char first = str.charAt(0);
    System.out.println(first);
//    int length = sol.lengthOfLongestSubstring("abcabcd");
//
//    System.out.println(length);
  }
}
