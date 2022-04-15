package main.java.math;

import java.util.Random;

/**
 * @author zhourup
 * @date 2022/4/15 13:16
 */
public class LeetCode382 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 链表长度未知，要求一轮遍历的情况下等概率随机返回链表的一个元素
     * 水塘抽样算法
     */
    class Solution {
        ListNode node;

        public Solution(ListNode head) {
            node = head;
        }

        public int getRandom() {
            return getRandom(node);
        }

        private int getRandom(ListNode node) {
            ListNode p = node;
            Random r = new Random();
            int i = 0, res = 0;
            while (p != null) {
                i++;
                if (0 == r.nextInt(i)) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
}
