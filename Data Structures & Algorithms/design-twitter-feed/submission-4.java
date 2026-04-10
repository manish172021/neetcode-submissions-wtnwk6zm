class Twitter {

    private Map<Integer, Integer> tweetsMap;
    private Map<Integer, Set<Integer>> userFollowMap;
    Stack<Integer> tweetIds;

    public Twitter() {
        tweetsMap = new HashMap<>();
        userFollowMap = new HashMap<>();
        tweetIds = new Stack<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetIds.push(tweetId);
        tweetsMap.put(tweetId, userId);
        userFollowMap.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> following = userFollowMap.get(userId);
        int count = 0;
        for (int i = tweetIds.size() - 1; i >= 0; i--) {
            int userId1 = tweetsMap.get(tweetIds.get(i));
            if(following.contains(userId1) || userId1 == userId) {
                ans.add(tweetIds.get(i));
                count++;
                if(count == 10) {
                    break;
                }
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = userFollowMap.get(followerId);
        following.remove(Integer.valueOf(followeeId));
        userFollowMap.put(followerId, following);
    }
}
