package main.java.others;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/5/3 11:59
 */
public class LeetCode969 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        List<Integer> res = pancakeSort(arr);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    static List<Integer> res = new LinkedList<>();

    /**
     * 思路：
     * 1、找到n个饼中最大的那个
     * 2、把这个最大的饼移到最下面
     * 3、递归调用pancakeSort(A,n-1)
     *
     * @param arr
     * @return
     */
    public static List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    /**
     * 确定第n个大的饼的位置
     *
     * @param arr
     * @param n
     */
    private static void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxCake) {
                maxCake = arr[i];
                maxCakeIndex = i;
            }
        }
        //将最大的饼放到最上面
        reverse(arr, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        //将最大的饼放到最下面
        reverse(arr, 0, n - 1);
        res.add(n);
        sort(arr, n - 1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
