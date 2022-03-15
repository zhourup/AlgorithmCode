package main.java.notes;

import java.util.PriorityQueue;

/**
 * 哈弗曼树+贪心
 */
public class Code_02_Less_Money {

    /**
     * 一块金条切成两半，是需要花费和长度数值- -样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
     * 一群人想整分整块金条，怎么分最省铜板?
     * 例如,给定数组{10, 20, 30)，代表-共三个人， 整块金条长度为10+20+30=60.金条要分成10, 20, 30三个部分。
     * 如果， 先把长度60的金条分成10和50，花费60再把长度50的金条分成20和30,花费50一共花费1 10铜板。但是如果，先把长度60的金条分
     * 成30和30，花费60再把长度30金条分成10和20，花费30 一共花费90铜板。
     * 输入一个数组，返回分割的最小代价。
     *
     * @param arr
     * @return
     */
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(); // 堆
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
