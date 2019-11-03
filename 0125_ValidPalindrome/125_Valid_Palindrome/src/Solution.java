public class Solution {

  public boolean isPalindrome(String s) {
    if(s==null|s.length()==0){
      return true;
    }
    String lower_s = s.toLowerCase();
    String delete_s = lower_s.replaceAll(" ","");
//    System.out.println(delete_s);
    int left = 0;
    int right = delete_s.length()-1;
    int leftASIC=0;
    int rightASIC=0;
    while(left<=right){
      leftASIC = (int)delete_s.charAt(left);
      rightASIC = (int)delete_s.charAt(right);

      while((!((((leftASIC)<123)&((leftASIC)>96))|(((leftASIC)<58)&((leftASIC)>47)))) & (left<delete_s.length()) ){
        left++;
        if(left<delete_s.length()){
          leftASIC = (int)delete_s.charAt(left);
        }
        else{
          //to avoid overflow
          left --;
          break;
        }
      }
      while((!((((rightASIC)<123)&((rightASIC)>96))|(((rightASIC)<58)&((rightASIC)>47))))& (right>=0) ){
        right--;
        if(right>=0){
          rightASIC = (int)delete_s.charAt(right);
        }
        else{
          //to avoid overflow
          right++;
          break;
        }
      }
      leftASIC = (int)delete_s.charAt(left);
      rightASIC = (int)delete_s.charAt(right);
      if (delete_s.charAt(left) == delete_s.charAt(right)) {
        left++;
        right--;
      }
      else if(!((((leftASIC)<123)&((leftASIC)>96))|(((leftASIC)<58)&((leftASIC)>47)))){
        return true;
      }
      else{
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
//    System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(sol.isPalindrome("0P"));

  }
}
