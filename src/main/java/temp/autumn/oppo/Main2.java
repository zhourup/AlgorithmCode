package temp.autumn.oppo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {


    static public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode combineTwoDisorderNodeToOrder(ListNode node1, ListNode node2) {
        List<Integer> list1 = getList(node1);
        list1.addAll(getList(node2));
        Collections.sort(list1);
        return getNode(list1);
    }

    private static List<Integer> getList(ListNode node) {
        List<Integer> res = new ArrayList<>();
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res;
    }

    private static ListNode getNode(List<Integer> list) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        for (Integer num : list) {
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = curr.next;
        }
        return preHead.next;
    }
}
