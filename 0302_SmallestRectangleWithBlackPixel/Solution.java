class Solution {
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;
        int left = findLeft(image, 0, y, true);
        int right = findRight(image, y, col - 1, true);
        int up = findLeft(image, 0, x, false);
        int down = findRight(image, x, row - 1, false);
        return (right - left + 1) * (down - up + 1);
    }
    public int findLeft(char [][]image, int start, int end, boolean isHorizon){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(hasBlack(image, mid, isHorizon)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(hasBlack(image, start, isHorizon)){
            return start;
        }
        else{
            return end;
        }
    }
    public int findRight(char [][]image, int start, int end, boolean isHorizon){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(hasBlack(image, mid, isHorizon)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(hasBlack(image, end, isHorizon)){
            return end;
        }
        else{
            return start;
        }
    }
    public boolean hasBlack(char [][]image, int pos, boolean isHorizon){
        if(isHorizon){
            for(int i = 0; i < image.length; i++){
                if(image[i][pos] == '1'){
                    return true;
                }
            }
        }
        else{
            for(int i = 0; i < image[0].length; i++){
                if(image[pos][i] == '1'){
                    return true;
                }
            }
            
        }
        return false;
    }
}
