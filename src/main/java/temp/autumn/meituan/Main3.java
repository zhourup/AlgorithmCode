package temp.autumn.meituan;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        play(nums);
    }

    private static void play(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            return;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            linkedList.addFirst(nums[i]);
            linkedList.addFirst(linkedList.removeLast());
            linkedList.addFirst(linkedList.removeLast());
        }
        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }
    }
}
