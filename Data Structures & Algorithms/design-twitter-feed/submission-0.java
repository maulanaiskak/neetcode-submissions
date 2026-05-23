class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    private int timestamp;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        var tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[]{timestamp++, tweetId});
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        var followees = followMap.get(userId);
        var maxHeap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

        for (var entry : tweetMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            if (key == userId || (followees != null && followees.contains(key))) {
                for (var tweet : value) {
                    maxHeap.offer(tweet);
                }
            }
        }

        var result = new ArrayList<Integer>();
        for (var i = 0; i < 10; i++) {
            var tweet = maxHeap.poll();

            if (tweet != null) {
                result.add(tweet[1]);
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        var followees = followMap.getOrDefault(followerId, new HashSet<>());
        
        if (followees.add(followeeId)) {
            followMap.put(followerId, followees);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            return;
        }

        var followees = followMap.get(followerId);
        
        followees.remove(followeeId);
    }
}
