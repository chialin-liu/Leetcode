public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String res = "";
        if(strs == null || strs.size() == 0) return res;
        for(String cur: strs){
            res = res + String.valueOf(cur.length()) + "/" + cur;
            // res += cur;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        while(i < s.length()){
            int index = s.indexOf("/", i);
            int size = Integer.valueOf(s.substring(i, index));
            res.add(s.substring(index + 1, index + 1 + size));
            i = index + 1 + size;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
