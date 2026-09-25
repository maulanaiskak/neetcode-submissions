class Twitter {
    private final Map<Integer, Set<Integer>> following;
    private final Map<Integer, List<int[]>> tweets;
    private int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(
            userId, 
            k -> new ArrayList<>()).add(new int[] {time++, tweetId}
        );
    }

    public List<Integer> getNewsFeed(int userId) {
        var users = new HashSet<>(following.getOrDefault(userId, Set.of()));
        users.add(userId);

        var heap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        for (int u : users) {
            for (var t : tweets.getOrDefault(u, List.of())) {
                heap.offer(t);
                if (heap.size() > 10) heap.poll();
            }
        }

        var result = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            result.add(0, heap.poll()[1]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(
            followerId, 
            k -> new HashSet<>()
        ).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        var set = following.get(followerId);
        
        if (set != null) {
            set.remove(followeeId);
        }
    }
}