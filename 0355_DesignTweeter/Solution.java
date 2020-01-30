class Twitter {
    int timeStamp;
    Map<Integer, User> userMap;
    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
        userMap = new HashMap<>();
    }
    class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.id = id;
            time = timeStamp;
            timeStamp++;
            next = null;
        }
    }
    class User{
        int id;
        Set<Integer> followee;
        Tweet tweetHead;
        public User(int id){
            this.id = id;
            followee = new HashSet<>();
            follow(id);
            tweetHead = null;
        }
        public void follow(int id){
            followee.add(id);
        }
        public void unfollow(int id){
            followee.remove(id);
        }
        public void post(int twId){
            Tweet t = new Tweet(twId);
            t.next = tweetHead;
            // t = tweetHead;
            tweetHead = t;
        }
    }
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return list;
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>(new Comparator<Tweet>(){
            public int compare(Tweet t, Tweet s){
                return s.time - t.time;
            }
        });
        Set<Integer> friends = userMap.get(userId).followee;
        for(int friend: friends){
            Tweet t = userMap.get(friend).tweetHead;
            if(t != null){
                queue.offer(t);
            }
        }
        int n = 0;
        while(!queue.isEmpty() && n < 10){
            Tweet cur = queue.poll();
            list.add(cur.id);
            n++;
            if(cur.next != null){
                queue.offer(cur.next);
            }
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
