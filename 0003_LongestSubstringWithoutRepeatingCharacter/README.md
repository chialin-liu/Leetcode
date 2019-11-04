# Brute force
Time complexity is O(n^3), we iterate outer loop i as the start, and iterate j = i + 1 as inner loop to define the start/end
Then, if we know the start and end, iterate these elements and check duplicate using set
This method will TLE

# hashset
## cspiration video contains typo "Hashset方法set.remove(s.charAt(j++)); 后面加一个i - -，不需要进行i++" 
## code
 public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0, j = 0; i < n; i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
                i--;
            }
            else{
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
## code more preferred
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(left < s.length()){
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
                
            }
            set.remove(s.charAt(left));
            left++;
        }
        return max;
    }                                            
# Array
## Faster than hashset
## " " will run time error, space input will fail
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0; 
        int []arr = new int [128];
        int left = 0;
        int right = 0;
        while(left < s.length()){
            while(right < s.length() && arr[s.charAt(right)] == 0){
                arr[s.charAt(right)] = 1;
                max = Math.max(max, right - left + 1);
                right++;
            }
            arr[s.charAt(left)] = 0;
            left++;
        }
        return max;
    }
    
