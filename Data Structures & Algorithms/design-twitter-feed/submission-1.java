class Twitter {
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, Set<int[]>> feeds;
    private int timestamp;

    public Twitter() {
        followers = new HashMap<>();
        feeds = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        var feed = feeds.computeIfAbsent(userId, k -> new HashSet<>());
        
        feed.add(new int[] {timestamp, tweetId});
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        var result = new ArrayList<Integer>();
        var minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        var selfFeeds = feeds.getOrDefault(userId, Set.of());

        for (var feed : selfFeeds) {
            minHeap.offer(feed);

            if (minHeap.size() > 10) {
                minHeap.poll();
            }
        }

        var followees = followers.getOrDefault(userId, Set.of());

        for (var followee : followees) {
            var followeeFeeds = feeds.get(followee);
            if (followeeFeeds == null) {
                continue;
            }

            for (var feed : followeeFeeds) {
                minHeap.offer(feed);

                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll()[1]);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        var followees = followers.computeIfAbsent(followerId, k -> new HashSet<>());
        
        followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            return;
        }

        followers.get(followerId).remove(followeeId);
    }
}
