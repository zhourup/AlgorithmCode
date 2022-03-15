package main.java.weekcompetition.week267;

/**
 * @author zhourup
 * @date 2021/11/14 10:39
 */
public class LeetCode5927 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 2, 1, 3};
        int[] nums1 = {1, 1, 0, 6};
        int i = 0, count = 1, len = 1;
        while (i < nums.length) {
            if (count % 2 == 0) {
                turnNum(nums, i, i + len - 1);
                System.out.println("反转：" + i + "  " + (i + len - 1));
                System.out.println((nums.length - i) + " " + len);

            }
            for (int j = 0; j < len; j++) {
                i++;
            }
            ++count;
            ++len;
            if (nums.length - i <= len) {
                System.out.println("chanfu");
                if ((nums.length - i) % 2 == 0) {
                    turnNum(nums, i, nums.length - 1);
                }
                break;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }

    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode p1 = head;
        int n = 0;
        while (p1 != null) {
            p1 = p1.next;
            n++;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = head.val;
            head = head.next;
        }

        int i = 0, count = 1, len = 1;
        while (i < n) {
            if (count % 2 == 0) {
                turnNum(nums, i, i + len - 1);
            }
            for (int j = 0; j < len; j++) {
                i++;
            }
            ++count;
            ++len;
            if (n - i < len) {
                if ((n - i) % 2 == 0) {
                    turnNum(nums, i, n - 1);
                }
                break;
            }
        }

        ListNode res = new ListNode(-1);
        ListNode tm = res;
        for (int j = 0; j < n; j++) {
            ListNode node = new ListNode(nums[j]);
            tm.next = node;
            tm = tm.next;
        }
        return res.next;
    }

    private static void turnNum(int[] nums, int l, int r) {
        if (r >= nums.length) {
            r = nums.length - 1;
        }
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    private static ListNode[] changeNode(ListNode node) {
        ListNode ret = new ListNode(-1);
        ListNode p1 = ret;
        ListNode p2 = node;
        while (p2 != null) {
            p1.next = p2;
            ListNode next = p2.next;
            p2.next = null;
            p2 = next;
            p1 = p1.next;
        }
        return new ListNode[]{ret.next, p1};
    }


}
