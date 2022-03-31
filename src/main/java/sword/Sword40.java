package main.java.sword;

import java.util.PriorityQueue;

/**
 * @author zhourup
 * @date 2022/3/31 15:03
 */
public class Sword40 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] res = getLeastNumbers(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * 使用大根堆，首先将前k个数插入到大根堆中，随后从第k+1个数开始遍历，如果当前遍历的数比大根堆的要小，就把堆顶元素弹出，插入当前数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < q.peek()) {
                q.poll();
                q.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = q.poll();
        }
        return vec;
    }
}
