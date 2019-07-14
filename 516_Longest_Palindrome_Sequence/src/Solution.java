public class Solution {
  public int longestPalindromeSubseq(String s) {
    if(s==null|s.length()==0) {
      return 0;
    }
    return lps(s,0,s.length()-1);
  }
  public int lps(String s, int left, int right){
    if(left==right){
      return 1;
    }
    if(left+1==right){
      if(s.charAt(left)==s.charAt(right)){
        return 2;
      }
      else{
        return 1;
      }
    }
    if(s.charAt(left)==s.charAt(right)){
      left++;
      right--;
      return lps(s,left,right)+2;
    }
    else{
      int left_plus1= left+1;
      int right_minus1=right-1;
      return findMax(lps(s,left_plus1,right),lps(s,left,right_minus1));
    }
  }
  public int findMax(int a, int b){
    return (a>b)?a:b;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
  }
}
