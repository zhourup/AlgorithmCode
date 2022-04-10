package main.java.weekcompetition.week288;

import java.util.PriorityQueue;

/**
 * @author zhourup
 * @date 2022/4/10 10:47
 */
public class LeetCode6039 {

    public static void main(String[] args) {
        int[] nums = {92, 36, 15, 84, 57, 60, 72, 86, 70, 43, 16};
        int k = 62;
        System.out.println(maximumProduct(nums, k));
    }

    /**
     * 贪心+优先级队列
     * 思想：对数组中一个数+1，对数组总体的贡献值=其余数的乘积，所以只需要每一轮都对最小值+1即可
     * 如：6 3 3 2   对2+1，对数组的贡献值=6*3*3*3-6*3*3*2=54 =6*3*3
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            num += 1;
            pq.offer(num);
        }
        long res = 1;
        for (int num : pq) {
            res = (res * num) % 1000000007;
        }
        return (int) res;
    }
}
