//package temp.autumn.xiaomi;
//
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class ListNode<T> {
//    public T data;
//    public ListNode next;
//}
//
//class Solution {
//
//    /* Write Code Here */
//    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
//        List<Integer> list=new ArrayList<>();
//        while(head!=null){
//            list.add(head.data);
//            head=head.next;
//        }
//
//        for(int i=left-1;i<=left-1+(right-left)/2;i++){
//            int temp=list.get(i);
//            list.set(i,list.get(right-i));
//            list.set(right-i,temp);
//        }
//
//        ListNode<Integer> res=new ListNode<Integer>();
//        ListNode<Integer> temp=res;
//        for(int node:list){
//            ListNode<Integer> curr=new ListNode<Integer>();
//            curr.data=node;
//            temp.next=curr;
//            temp=temp.next;
//        }
//
//        head=res.next;
//        return res.next;
//    }
//}
//
//public class Main1 {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        ListNode<Integer> res = null;
//
//        int head_size = 0;
//        head_size = in.nextInt();
//        ListNode<Integer> head = null, head_curr = null;
//        for(int head_i = 0; head_i < head_size; head_i++) {
//            int head_item = in.nextInt();
//            ListNode<Integer> head_temp = new ListNode<Integer>();
//            head_temp.data = head_item;
//            head_temp.next = null;
//
//            if (head == null) {
//                head = head_curr = head_temp;
//            } else {
//                head_curr.next = head_temp;
//                head_curr = head_temp;
//            }
//        }
//
//        if(in.hasNextLine()) {
//            in.nextLine();
//        }
//
//        int left;
//        left = Integer.parseInt(in.nextLine().trim());
//
//        int right;
//        right = Integer.parseInt(in.nextLine().trim());
//
//        res = new Solution().reverseBetween(head, left, right);
//        while (res != null) {
//            System.out.print(String.valueOf(res.data) + " ");
//            res = res.next;
//        }
//        System.out.println();
//
//    }
//}
