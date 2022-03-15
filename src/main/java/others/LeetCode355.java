package main.java.others;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/31 16:13
 */
public class LeetCode355 {

    static class Twitter {

        //记录全部发布的推特
        List<int[]> twitters;
        //记录每个用户的关注对象
        Map<Integer, Set<Integer>> follows;

        public Twitter() {
            twitters = new ArrayList<>();
            follows = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            twitters.add(new int[]{userId, tweetId});
            follows.putIfAbsent(userId, new HashSet<>());
        }

        //根据用户id去查询用户获取该用户关注了哪些其他用户
        //获取自己和这些用户按照时间从近到远的十条推文
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            int n = twitters.size();
            int count = 0;
            Set<Integer> follow = follows.get(userId);
            for (int i = n - 1; i >= 0; i--) {
                int[] cur = twitters.get(i);
                if (cur[0] == userId || follow.contains(cur[0])) {
                    res.add(cur[1]);
                    count++;
                }
                if (count == 10) {
                    break;
                }
            }
            return res;
        }

        //在用户的关注集合里加入followeeId
        public void follow(int followerId, int followeeId) {
            if (!follows.containsKey(followerId)) {
                follows.put(followerId, new HashSet<>());
            }
            follows.get(followerId).add(followeeId);
        }

        //在用户的关注集合中移除followeeId
        public void unfollow(int followerId, int followeeId) {
            follows.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }

}
