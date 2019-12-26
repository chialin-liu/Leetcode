class Solution {
  public boolean canTransform(String start, String end) {
    if(start.length() != end.length()) return false;
    int i = 0;
    int j = 0;
    int n = start.length();
    int m = end.length();
    while(i < n && j < m){
      while(i < n && start.charAt(i) == 'X') ++i;
      while(j < m && end.charAt(j) == 'X') ++j;
      if(i < n && j < m && start.charAt(i) != end.charAt(j)) return false;
      if(i < n && j < m && start.charAt(i) == 'R' && i > j) return false;
      if(i < n && j < m && start.charAt(i) == 'L' && i < j) return false;
      if(i == n && j != m) return false;
      if(i != n && j == m) return false;
      i++;
      j++;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String start = "X";
    String end = "L";
    boolean res = sol.canTransform(start, end);
    System.out.println(res);
  }
}
