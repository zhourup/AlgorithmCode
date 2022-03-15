package main.java.heap;

import java.util.PriorityQueue;

/**
 * @author zhourup
 * @date 2021/12/30 21:17
 */
public class LeetCode295 {

    /**
     * 流数据中的中位数
     * 思路：使用个大根堆，小根堆。大根堆存储较小的一半数，小根堆存储较大的一半数
     * 如果元素总数是n，如果n是偶数，我们希望两个堆的元素个数是一样的，这样把两个堆的堆顶元素拿出来求平均数就是中位数
     * 如果n是奇数，那么两个堆的元素个数分别是n/2+1和n/2，那么元素较多的那个堆的堆顶元素就是中位数
     */
    static class MedianFinder {
        //大根堆，方便取出较小一批数中的最大那个数
        private PriorityQueue<Integer> small;
        //小根堆，方便取出较大一批数中的最小那个数
        private PriorityQueue<Integer> large;

        public MedianFinder() {
            //大根堆
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
            //小根堆
            large = new PriorityQueue<>();
        }

        /**
         * 不仅要维护large和small的元素个数不超过1，还要维护large堆的堆顶元素大于等于small堆的堆顶元素
         * 思路：往large里添加元素，不能直接添加，要先往small里添加，然后再把small的堆顶元素加到large中；向small中添加元素同理
         *
         * @param num
         */
        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (small.size() < large.size()) {
                return large.peek();
            }
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
