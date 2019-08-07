import java.util.*;

class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };



public class Solution {
  /*
   * @param node: A undirected graph node
   * @return: A undirected graph node
   */
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    // write your code here
    if(node == null)return node;
    List<UndirectedGraphNode> list = getNodes(node);
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    for(UndirectedGraphNode cur : list){
      map.put(cur, new UndirectedGraphNode(cur.label));
    }
    for(UndirectedGraphNode cur : list){
      UndirectedGraphNode newNode = map.get(cur);
      for(UndirectedGraphNode neighbor: cur.neighbors){
        newNode.neighbors.add(map.get(neighbor));
      }
    }
    return map.get(node);
  }
  public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
    HashSet<UndirectedGraphNode> set = new HashSet<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.offer(node);
    set.add(node);
    while(!queue.isEmpty()){
      UndirectedGraphNode cur = queue.poll();
      for(UndirectedGraphNode neighbor : cur.neighbors){
        if(!set.contains(neighbor)){
          queue.offer(neighbor);
          set.add(neighbor);
        }
      }
    }
    return new ArrayList<UndirectedGraphNode>(set);
  }
}
