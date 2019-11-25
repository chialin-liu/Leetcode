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
    int pointer = 0;
    int count = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n){
            if(pointer == 0){
                count = read4(temp);
            }
            if(count == 0) break;
            while(index < n && pointer < count){
                buf[index] = temp[pointer];
                index++;
                pointer++;
            }
            if(pointer == count) pointer = 0;
        }
        return index;
    }
}
