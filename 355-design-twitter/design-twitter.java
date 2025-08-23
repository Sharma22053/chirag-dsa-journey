class Twitter {
    private static int timeStamp = 0;
    private HashMap<Integer,User> hmap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            tweet_head = null;
            follow(id);
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head =t;

        }
    }

    public Twitter() {
        hmap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!hmap.containsKey(userId)){
            User user = new User(userId);
            hmap.put(userId,user);
        }
        hmap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!hmap.containsKey(userId)) return res;

        Set<Integer> users = hmap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a,b) -> (b.time-a.time));
        for(int user : users){
            Tweet t = hmap.get(user).tweet_head;
            if(t != null){
                pq.add(t);
            }
        }

        int n =0;
        while(!pq.isEmpty() && n<10){
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if(t.next != null){
                pq.add(t.next);
            }
            
        }
        return res;
    }

    
    public void follow(int followerId, int followeeId) {
        if(!hmap.containsKey(followerId)){
            User user = new User(followerId);
            hmap.put(followerId,user);
        }

        if(!hmap.containsKey(followeeId)){
            User user = new User(followeeId);
            hmap.put(followeeId,user);
        }
        hmap.get(followerId).follow(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!hmap.containsKey(followerId) || followerId == followeeId){
            return;
        }
        hmap.get(followerId).unfollow(followeeId);
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