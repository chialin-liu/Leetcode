public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0) {
      return 0;
    }
//    if(needle.length()>haystack.length()){
//      return -1;
//    }
    int startIndx = -1;
    int count = 0;
    for (int i = 0; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if(i+j>=haystack.length()){
          return -1;
        }
        if (haystack.charAt(i+j) != needle.charAt(j)) {
          break;
        }
        else {
          if(j==0){
            startIndx = i;
          }
          if (j == needle.length()-1) {
            return startIndx;
          }
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    int index = sol.strStr("aaa",
            "aaaa");
    System.out.println(index);
  }
}
