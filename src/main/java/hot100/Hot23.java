package main.java.hot100;

import java.util.*;

public class Hot23 {

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

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode[] list = new ListNode[3];
        ListNode head1 = createListSZ(nums1);
        ListNode head2 = createListSZ(nums2);
        ListNode head3 = createListSZ(nums3);
        list[0] = head1;
        list[1] = head2;
        list[2] = head3;
        ListNode head = mergeKLists2(list);
        printListNode(head);

    }

    /**
     * 法二、每次O(K)比较k个指针求min，时间复杂度O(NK)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minNode == null) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;

        }
        return dummyHead.next;
    }

    /**
     * 法三、使用小跟堆对1进行优化，每次O(logK)比较k个指针求min，时间复杂度O(Nlogk)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }

    /**
     * 法一、先把所有元素放到List，排序，再产生链表
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeList = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                nodeList.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(nodeList);
        ListNode head = createList(nodeList);
        return head;
    }


    private static ListNode createListSZ(int[] nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }


    private static ListNode createList(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < nums.size(); i++) {
            ListNode node = new ListNode(nums.get(i));
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}
