package main.java.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhourup
 * @date 2022/1/3 20:26
 */
public class LeetCode870 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{13, 25, 32, 11};
        int[] res = advantageCount(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 田忌赛马的思路：打得过就打，打不过就拿自己的垃圾和对方的精锐互换
     * 将齐王和田忌的马按照战斗力排序，然后按照排名一一对比，如果田忌的马能赢，那就比赛。如果赢不了，那就换个垫底的来送人头，保存实力
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //num2降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                //nums1的大于nums2的，直接是
                res[i] = nums1[right];
                right--;
            } else {
                //nums1不能打赢nums2的，拿最小的来换
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

}
