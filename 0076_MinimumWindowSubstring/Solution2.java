class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        int from = 0;
        int [] arr = new int [128];
        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i)]++;
        }
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(arr[s.charAt(i)] > 0){
                total--;
            }
            arr[s.charAt(i)]--;
            
            while(total == 0){
                if(min > i - j + 1){
                    min = i - j + 1;
                    from = j;
                }
                arr[s.charAt(j)]++;
                if(arr[s.charAt(j)] > 0) {
                    total++;
                }
                j++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "": s.substring(from, from + min);
    }
}
