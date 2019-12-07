class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) return logs;
        int lenLetter = 0;
        boolean [] isLetter = new boolean [logs.length];
        for(int i = 0; i < logs.length; i++){
            if(!Character.isDigit(logs[i].charAt(logs[i].length() - 1))){
                lenLetter++;
                isLetter[i] = true;
            }
        }
        String []res = new String[logs.length];
        for(int resIndex = 0, letterIndex = 0, digitIndex = lenLetter; resIndex < logs.length; resIndex++){
            if(isLetter[resIndex] == true){
                res[letterIndex] = logs[resIndex];
                letterIndex++;
            }
            else{
                res[digitIndex] = logs[resIndex];
                digitIndex++;
            }
        }
        Arrays.sort(res, 0, lenLetter, new Comparator<String>(){
           public int compare(String s1, String s2){
               int index1 = s1.indexOf(" ");
               int index2 = s2.indexOf(" ");
               String identifier1 = s1.substring(0, index1);
               String identifier2 = s2.substring(0, index2);
               String last1 = s1.substring(index1 + 1);
               String last2 = s2.substring(index2 + 1);
               if(!last1.equals(last2)){
                   return last1.compareTo(last2);
               }
               else{
                   return identifier1.compareTo(identifier2);
               }
           } 
        });
        return res;
    }
}
