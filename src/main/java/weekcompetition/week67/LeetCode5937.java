package main.java.weekcompetition.week67;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/11 23:23
 */
public class LeetCode5937 {
    static class SORTracker {

        class Scenic {
            String name;
            int score;

            public Scenic(String name, int score) {
                this.name = name;
                this.score = score;
            }
        }

        /**
         * 思路：小根堆数据的数量对应查询次数，数量为5，则小根堆取出的值则是第5好的景点。查询一次则从大根堆中取一个数到小根堆中，维护数量
         * 大根堆中的数都比小根堆中的数小
         */
        //小根堆
        Queue<Scenic> scenics1;
        //大根堆
        Queue<Scenic> scenics2;

        public SORTracker() {
            scenics1 = new PriorityQueue<>(new Comparator<Scenic>() {
                @Override
                public int compare(Scenic o1, Scenic o2) {
                    if (o1.score != o2.score) {
                        return o1.score - o2.score;
                    } else {
                        return o2.name.compareTo(o1.name);
                    }
                }
            });
            scenics2 = new PriorityQueue<>(new Comparator<Scenic>() {
                @Override
                public int compare(Scenic o1, Scenic o2) {
                    if (o1.score != o2.score) {
                        return o2.score - o1.score;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            });
        }

        public void add(String name, int score) {
            scenics1.offer(new Scenic(name, score));
            scenics2.offer(scenics1.poll());
            System.out.println("scenics1:" + scenics1.size());
            System.out.println("scenics2:" + scenics2.size());
        }

        public String get() {
            scenics1.offer(scenics2.poll());
            return scenics1.peek().name;
        }
    }

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker();
        tracker.add("bradford", 2); // 添加 name="bradford" 且 score=2 的景点。
        tracker.add("branford", 3); // 添加 name="branford" 且 score=3 的景点。
        System.out.println(tracker.get());         // 从好带坏的景点为：branford ，bradford 。
//        // 注意到 branford 比 bradford 好，因为它的 评分更高 (3 > 2) 。
//        // 这是第 1 次调用 get() ，所以返回最好的景点："branford" 。
//        tracker.add("alps", 2);     // 添加 name="alps" 且 score=2 的景点。
//        System.out.println(tracker.get());              // 从好到坏的景点为：branford, alps, bradford 。
//        // 注意 alps 比 bradford 好，虽然它们评分相同，都为 2 。
//        // 这是因为 "alps" 字典序 比 "bradford" 小。
//        // 返回第 2 好的地点 "alps" ，因为当前为第 2 次调用 get() 。
//        tracker.add("orland", 2);   // 添加 name="orland" 且 score=2 的景点。
//        System.out.println(tracker.get());              // 从好到坏的景点为：branford, alps, bradford, orland 。
//        // 返回 "bradford" ，因为当前为第 3 次调用 get() 。
//        tracker.add("orlando", 3);  // 添加 name="orlando" 且 score=3 的景点。
//        System.out.println(tracker.get());              // 从好到坏的景点为：branford, orlando, alps, bradford, orland 。
//        // 返回 "bradford".
//        tracker.add("alpine", 2);   // 添加 name="alpine" 且 score=2 的景点。
//        System.out.println(tracker.get());              // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
//        // 返回 "bradford" 。
//        System.out.println(tracker.get());             // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
//        // 返回 "orland" 。
    }
}
