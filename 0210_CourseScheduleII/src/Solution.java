import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  /*
   * @param numCourses: a total of n courses
   * @param prerequisites: a list of prerequisite pairs
   * @return: true if can finish all courses or false
   */
  public int [] findOrder(int numCourses, int[][] prerequisites) {
    // write your code here
//    if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
//      return new int[0];
//    }
    int [] degree = new int [numCourses];
    List<Integer> [] edge  = new ArrayList [numCourses];
    for(int i = 0; i < numCourses; i++){
      edge[i] = new ArrayList<>();
    }
    int [] resArray = new int [numCourses];
    int m = prerequisites.length;
    for(int i = 0; i < m; i++){
      degree[prerequisites[i][0]]++;
//      int see = prerequisites[i][1];
//      int add = prerequisites[i][0];
      edge[prerequisites[i][1]].add(prerequisites[i][0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < numCourses; i++){
      if(degree[i] == 0){
        queue.offer(i);
      }
    }
    int res = 0;
    while(!queue.isEmpty()){
      int cur = queue.poll();
      resArray[res] = cur;
      res++;
      int edge_size = edge[cur].size();
      for(int i = 0; i < edge_size; i++){
        int edge_index = edge[cur].get(i);
        degree[edge_index]--;
        if(degree[edge_index] == 0){
          queue.offer(edge_index);
        }
      }
    }
    if(res == numCourses){
      return resArray;
    }
    return new int[1];
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int arr[][] = {
    };
    System.out.println(sol.findOrder(6,arr));
  }
}
