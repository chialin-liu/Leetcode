class Solution {
    public int compareVersion(String version1, String version2) {
        int len = Math.max(version1.length(), version2.length());
        String []v1 = version1.split("\\.");
        String []v2 = version2.split("\\.");
        int res = 0;
        for(int i = 0; i < len; i++){
            String v1Str = (i > v1.length - 1)? "0": v1[i];
            String v2Str = (i > v2.length - 1)? "0": v2[i];
            Integer v1Int = Integer.valueOf(v1Str);
            Integer v2Int = Integer.valueOf(v2Str);
            res = v1Int.compareTo(v2Int);
            if(res != 0){
                return res > 0? 1: -1;
            }
        }
        return res;
    }
}
