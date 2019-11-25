/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
         char[] tmp = new char[4];
        int index = 0;
        while(true){
            int count = read4(tmp);
            count = Math.min(count, n - index);
            for(int i = 0; i < count; i++){
                buf[index] = tmp[i];
                index++;
            }
            if(index == n || count < 4) return index;
        }
    }
}
