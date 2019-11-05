 class node{
        int dist;
        int worker;
        int bike;
        public node(int dist, int worker, int bike){
            this.dist = dist;
            this.worker = worker;
            this.bike = bike;
        } 
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans,-1);
        boolean[] used = new boolean[bikes.length];
        int cnt = 0;
        PriorityQueue<node> heap = new PriorityQueue<node>(new Comparator<node>(){
             @Override
            public int compare(node o1, node o2){
                if(o1.dist == o2.dist){
                    if(o1.worker == o2.worker){
                        return o1.bike - o2.bike;
                    }
                    return o1.worker - o2.worker;
                }else{
                    return o1.dist - o2.dist;
                }
            }
        });
            
     
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                int dist = calDist(workers[i],bikes[j]);
                node n = new node(dist,i,j);
                heap.offer(n);
            }
        }
        while(cnt != workers.length){
            node cur = heap.poll();
            int index = cur.worker;
            int bike = cur.bike;
            if(ans[index] == -1 && !used[bike]){
                ans[index] = bike;
                used[bike] = true;
                cnt++;
            }
        }
        return ans;
        
    }
    public int calDist(int[] worker, int[] bikes){
        return Math.abs(worker[0] - bikes[0]) + Math.abs(worker[1] - bikes[1]);
    }
