import java.util.*;

class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> height = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int prev = 0;
    for(int []b : buildings){
      List<Integer> enter = new ArrayList<>();
      List<Integer> leave = new ArrayList<>();
      enter.add(b[0]);
      enter.add(-b[2]);
      leave.add(b[1]);
      leave.add(b[2]);
      height.add(enter);
      height.add(leave);
    }
    class HeightComparator implements Comparator<List<Integer>> {
      public int compare(List<Integer> h1, List<Integer> h2){
        if(h1.get(0).equals(h2.get(0))){
          return h1.get(1) - h2.get(1);
        }
        else{
          return h1.get(0) - h2.get(0);
          // return h2.get(0) - h1.get(0);

        }
      }
    }
    Collections.sort(height, new HeightComparator()


    );
    TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
    });
    // TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    map.put(0, 1);
    for(List<Integer> list: height){
      int hei = list.get(1);
      int position = list.get(0);
      if(hei < 0){
        map.put(-hei, map.getOrDefault(-hei, 0) + 1);
      }
      else{
        int count = map.get(hei);
        if(count == 1){
          map.remove(hei);
        }
        else{
          count--;
          map.put(hei, count);
        }
      }
      int curHeight = map.firstKey();

      List<Integer> temp = new ArrayList<>();
      if(prev != curHeight){
        temp.add(position);
        temp.add(curHeight);
        prev = curHeight;
        res.add(temp);
      }

    }
    return res;
  }

  // public static void main(String[] args) {
  //   Solution sol = new Solution();
  //   int [][]building = new int [][]{{9000, 10001, 19001}, {9001, 10001, 1000}, {9002, 10001, 999}};
  //   List<List<Integer>> res = sol.getSkyline(building);
  //   System.out.println(res);
  // }
}
