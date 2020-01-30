/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(List<Interval> people: schedule){
            for(Interval time: people){
                queue.offer(time);
            }
        }
        Interval temp = queue.poll();
        List<Interval> res = new ArrayList<>();
        while(!queue.isEmpty()){
            if(temp.end < queue.peek().start){
                res.add(new Interval(temp.end, queue.peek().start));
                temp = queue.poll();
            }
            else{
                temp.end = Math.max(temp.end, queue.peek().end);
                queue.poll();
            }
        }
        return res;
    }
}
