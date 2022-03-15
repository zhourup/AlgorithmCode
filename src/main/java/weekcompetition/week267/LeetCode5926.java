package main.java.weekcompetition.week267;

/**
 * @author zhourup
 * @date 2021/11/14 10:31
 */
public class LeetCode5926 {

    public static void main(String[] args) {
        int[] nums = {84, 49, 5, 24, 70, 77, 87, 8};
        int k = 3;
        System.out.println(timeRequiredToBuy(nums, k));

    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == 0) {
                    continue;
                } else {
                    tickets[i]--;
                    time++;
                    if (tickets[k] == 0) {
                        return time;
                    }
                }
            }
        }
        return time;
    }
}
