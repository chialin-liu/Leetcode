class Solution {
    public String convert(String s, int numRows) {
        StringBuilder [] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder("");
        }
        if(s == null || s.length() == 0){
            return "";
        }
        if(numRows == 1) return s;
        for(int i = 0; i < s.length(); i++){
            int index = i % (numRows * 2 - 2);
            index = index < numRows ? index: numRows * 2 - 2 - index;
            sb[index].append(s.charAt(i));
        }
        for(int i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
