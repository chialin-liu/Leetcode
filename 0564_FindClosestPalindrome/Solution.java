class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0 ? true: false; 
        int mid = (even)? len / 2 - 1: len / 2;
        Long numLeft = Long.parseLong(n.substring(0, mid + 1));
        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalin(numLeft, even));
        candidate.add(getPalin(numLeft + 1, even));
        candidate.add(getPalin(numLeft - 1, even));
        candidate.add((long)Math.pow(10, len - 1) - 1);
        candidate.add((long)Math.pow(10, len) + 1);
        
        Long diff = Long.MAX_VALUE;
        Long res = Long.MAX_VALUE;
        Long num = Long.parseLong(n);
        for(long cand: candidate){
            if(num == cand) continue;
            else if(Math.abs(cand - num) < diff){
                diff = Math.abs(cand - num);
                res = cand;
            }
            else if(Math.abs(cand - num) == diff){
                res = Math.min(res, cand);
            }
            
        }
        return String.valueOf(res);
    }
    public Long getPalin(long str, boolean even){
        long res = str;
        if(!even){
            str = str / 10;
        }
        while(str != 0){
            res = res * 10 + str % 10;
            str = str / 10;
        }
        return res;
    }
}
