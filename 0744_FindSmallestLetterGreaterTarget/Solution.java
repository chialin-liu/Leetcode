class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(letters[mid] - 'a' > target - 'a'){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(letters[start] - 'a' > target - 'a'){
            return letters[start];
        }
        else if(letters[end] - 'a' > target - 'a'){
            return letters[end];
        }
        else{
            return letters[0];
        }
    }
}
