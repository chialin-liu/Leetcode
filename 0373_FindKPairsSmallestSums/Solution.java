class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>(){
            public int compare(List<Integer> list1, List<Integer> list2){
                return (list1.get(0) + list1.get(1)) - (list2.get(0) + list2.get(1));
            }
        });
        for(int i = 0; i < nums1.length && i < k; i++){
            list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[0]);
            list.add(0);
            queue.offer(new ArrayList<>(list));
        }
        while(k > 0 && !queue.isEmpty()){
            k--;
            List<Integer> cur = queue.poll();
            int num1Value = cur.get(0);
            int num2Value = cur.get(1);
            int index = cur.get(2);
            cur.remove(2);
            res.add(new ArrayList<>(cur));
            if(index == nums2.length - 1) continue;
            cur.set(1, nums2[index + 1]);
            cur.add(2, index + 1);
            queue.offer(new ArrayList<>(cur));
        }
        return res;
    }
}
