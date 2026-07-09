class Twitter {
    //user->list<followed>
    //user->list<post>
    //user-> userid,postId,3(recent_post)

    //put the follow post in pq sort in recent_post
    //pq add <postid,recent_post>, have a counter for person while getting feed
    int MAX_SIZE = 500;
    int followedUsers[][];//<userId>
    HashMap<Integer,List<Integer>> tweetOfUsers;
    int usersRecentTweet[][];//<tweetId,3>
    HashMap<Integer,Integer> tweets;
    public Twitter() {
        followedUsers = new int[MAX_SIZE][MAX_SIZE];
        tweetOfUsers = new HashMap<>();
        usersRecentTweet = new int[MAX_SIZE][2];
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.put(tweetId,tweets.size());
        List<Integer> uTweets = tweetOfUsers.getOrDefault(userId,new LinkedList<>());
        uTweets.add(tweetId);
        tweetOfUsers.put(userId,uTweets);
        usersRecentTweet[userId] =  new int[]{tweetId,tweets.get(tweetId)};
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int tweetPointerCounter[] = new int[MAX_SIZE];
        int followees[] = followedUsers[userId];
        followees[userId] = 1;
        List<Integer> recentTweets = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2] - a[2]);
        for(int i = 0; i < MAX_SIZE; i++){
            if(followees[i] == 1 && tweetOfUsers.getOrDefault(i,new LinkedList<>()).size()>0){
                int recentTweet[] = usersRecentTweet[i];
                pq.add(new int[]{i,recentTweet[0],recentTweet[1]});
                tweetPointerCounter[i] = 1;
            }
        }
        int size = 0;
        // for(int i[]:pq) System.out.println(Arrays.toString(i));
        while(size<10 && !pq.isEmpty()){
            int tweet[] = pq.remove();
            recentTweets.add(tweet[1]);
            List<Integer> usersTweet = tweetOfUsers.getOrDefault(tweet[0],new LinkedList<>());
            if(usersTweet.size() - ++tweetPointerCounter[tweet[0]]>=0){
                int nextRecentTweet = usersTweet.get(usersTweet.size() - tweetPointerCounter[tweet[0]]);
                pq.add(new int[]{tweet[0],nextRecentTweet,tweets.get(nextRecentTweet)});
            }
            size++;
        }
        return recentTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        followedUsers[followerId][followeeId] = 1;
    }
    
    public void unfollow(int followerId, int followeeId) {
        followedUsers[followerId][followeeId] = 0;
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