public class Solution {
  class Result{
    public int start;
    public int maxLength;
    Result(int start, int maxLength){
      this.start=start;
      this.maxLength=maxLength;
    }
  }
  public String longestPalindrome(String s) {
    if(s==null|s.length()<2){
      return s;
    }
    int maxLength=0;
    int start=0;
    Result finalResult=new Result(start,maxLength);
    for(int i = 0;i<s.length();i++){
      finalResult=checkPalin(s,i,i,finalResult);//center point is i
      finalResult=checkPalin(s,i,i+1,finalResult);//even string
    }
    return s.substring(finalResult.start,finalResult.start+finalResult.maxLength);
  }
  public Result checkPalin(String s, int left,int right, Result result){
//    Result returnResult=new Result(0,0);
    int maxLength=1;
    while(left>=0 & right<s.length()){
      if(s.charAt(left)==s.charAt(right)){
        left--;
        right++;
      }
      else {
        break;
      }
    }
    if(right-left-1>maxLength){
      maxLength=right-left-1;
    }

    if(maxLength>result.maxLength){
      result.maxLength=maxLength;
      result.start=left+1;
    }
    return result;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.longestPalindrome("babad"));
  }
}
