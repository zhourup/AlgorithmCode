package main.java.greedy;

/**
 * @author zhourup
 * @date 2022/4/2 17:25
 */
public class LeetCode134 {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 法一、图解法
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //相当于图像中的坐标点和最低点
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return start == n ? 0 : start;
    }

    /**
     * 法二、贪心
     * 关键思路：如果选择站点i作为起点恰好无法走到j，那么i和j中间的任意站点k都不可能作为起点
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            //总的油量小于总的消耗，无解
            return -1;
        }
        //记录总的油量
        int tank = 0;
        //记录起点
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                //无法从start走到i,所以i+1是起点
                tank = 0;
                start = i + 1;
            }
        }
        return start == n ? 0 : start;
    }
}
