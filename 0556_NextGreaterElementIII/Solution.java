class Solution {
    public int nextGreaterElement(int n) {
        int lucky = -1;
        int luckyIndex = 0;
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(0, n % 10);
            n = n / 10;
        }
        for(int i = list.size() - 2; i >= 0; i--){
            if(list.get(i) >= list.get(i + 1)) continue;
            else{
                lucky = list.get(i);
                luckyIndex = i;
                break;
            }
        }
        if(lucky == -1){
            return -1;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) > lucky){
                int temp = list.get(i);
                list.set(i, lucky);
                list.set(luckyIndex, temp);
                break;
            }
        }
        reverse(list, luckyIndex + 1);
        int number = 0;
        for(int i = 0; i < list.size(); i++){
            number = number * 10 + list.get(i);
            if(number >= Integer.MAX_VALUE / 10)  return -1;
        }
        return number;
    }
    public void reverse(List<Integer> list, int start){
        int end = list.size() - 1;
        while(start <= end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}
