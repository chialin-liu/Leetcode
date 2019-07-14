public class Solution2 {
  public int longestPalindromeSubseq(String s) {
    if(s==null|s.length()==0){
      return 0;
    }
    int [][]dp = new int [s.length()][s.length()];
    //length=1
    for(int i = 0;i<s.length();i++) {
      dp[i][i] = 1;
    }
    //length=2
    for(int length=2;length<=s.length();length++){
      for(int i=0, j=i+(length-1);j<s.length();i++,j++){
          if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=dp[i+1][j-1]+2;
          }
          else{
            dp[i][j]=findMax(dp[i+1][j],dp[i][j-1]);
          }
      }
    }
    return dp[0][s.length()-1];
  }
  public int findMax(int a, int b){
    return (a>b)?a:b;
  }
    public static void main(String[] args) {
    Solution2 sol = new Solution2();
    System.out.println(sol.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
//      System.out.println(sol.longestPalindromeSubseq("bbbab"));

    }
}
