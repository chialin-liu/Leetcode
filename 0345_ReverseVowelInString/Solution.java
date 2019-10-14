class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        if(s == null || s.length() == 0) return s;
        char [] arr = s.toCharArray();
        while(left <= right){
            while(left <= right && (s.charAt(left) != 'a') && (s.charAt(left) != 'e') && (s.charAt(left) != 'i') && (s.charAt(left) != 'o') && (s.charAt(left) != 'u') && (s.charAt(left) != 'A') && (s.charAt(left) != 'E') && (s.charAt(left) != 'I') && (s.charAt(left) != 'O') && (s.charAt(left) != 'U')){
                left++;
            }
            while(left <= right && (s.charAt(right) != 'a') && (s.charAt(right) != 'e') && (s.charAt(right) != 'i') && (s.charAt(right) != 'o') && (s.charAt(right) != 'u') && (s.charAt(right) != 'A') && (s.charAt(right) != 'E') && (s.charAt(right) != 'I') && (s.charAt(right) != 'O') && (s.charAt(right) != 'U')){
                right--;
            }
            if(left <= right){
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;   
            }
            
        }
        return String.valueOf(arr);
    }
}
