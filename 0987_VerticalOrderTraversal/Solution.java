class Solution {
    class Obj {
        int x;
        int y;
        int val;
        public Obj(int x, int y, int val){
             this.x = x;
             this.y = y;
             this.val = val;
        }
    }
       
    public List<List<Integer>> verticalTraversal(TreeNode root) {
          List<List<Integer>> res = new ArrayList<>();
          if(root == null) return res;
          PriorityQueue<Obj> pq = new PriorityQueue<>(new Comparator<Obj>(){
              public int compare(Obj o1, Obj o2){
                  if(o1.x != o2.x){
                       return o1.x - o2.x;
                  }
                  else if(o1.y != o2.y){
                       return o2.y - o1.y; 
                  }
                  else{
                       return o1.val - o2.val;
                  }
              }
           });
          preOrder(root, 0, 0, pq);
          int prev = Integer.MIN_VALUE;
          while(!pq.isEmpty()){
              Obj cur = pq.poll();
              if(cur.x > prev){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    res.add(list);
              }
              else{
                    List<Integer> list = res.get(res.size() - 1);
                    list.add(cur.val);
              }
              prev = cur.x;

          }
          return res;
                  

    }
    public void preOrder(TreeNode root, int x, int y, PriorityQueue<Obj> pq){
         if(root ==  null) return ;
         pq.offer(new Obj(x, y, root.val));
         preOrder(root.left, x - 1, y - 1, pq);
         preOrder(root.right, x + 1, y - 1, pq);
    }
    
}

