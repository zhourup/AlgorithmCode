package main.java.others;

/**
 * @author zhourup
 * @date 2022/3/24 16:11
 */
public class Alibaba20200320_01 {

    /**
     * 有一叠扑克牌，每张牌介于1和10之间。有四种出牌方法：
     * <p>
     * 单出一张
     * 出两张相同的牌(对子)
     * 出五张顺子(如12345)
     * 出三连对子(如112233)
     * 给10个数，表示1-10每种牌有几张，问最少要多少次能出完。每种牌最多有四张。
     */
    static int[] nums = {0, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        dfs(0);
        System.out.println("ans:" + ans);
    }

    public static void dfs(int k) {
        //检查是否有三连对子
        for (int i = 1; i <= 8; i++) {
            boolean flag = true;
            for (int j = i; j < i + 3; j++) {
                //不能构成三连对
                if (nums[j] < 2) {
                    flag = false;
                    break;
                }
            }
            //可以构成三连对
            if (flag) {
                for (int j = i; j < i + 3; j++) {
                    nums[j] -= 2;
                }
                dfs(k + 1);
                //回溯一步
                for (int j = i; j < i + 3; j++) {
                    nums[j] += 2;
                }
            }
        }

        //检查是否有顺子
        for (int i = 1; i <= 6; i++) {
            boolean flag = true;
            for (int j = i; j < i + 5; j++) {
                if (nums[j] < 1) {
                    flag = false;
                    break;
                }
            }
            //可以构成顺子
            if (flag) {
                for (int j = i; j < i + 5; j++) {
                    nums[j] -= 1;
                }
                dfs(k + 1);
                for (int j = i; j < i + 5; j++) {
                    nums[j] += 1;
                }
            }
        }

        //没有三连对和顺子，直接统计答案
        int cnt = 0;
        for (int i = 1; i <= 10; i++) {
            //直接构成两个一对
            if (nums[i] == 4) {
                cnt += 2;
            } else if (nums[i] == 3) {
                cnt += 2;
            } else if (nums[i] == 2) {
                cnt += 1;
            } else if (nums[i] == 1) {
                cnt += 1;
            }
        }
        ans = Math.min(ans, cnt + k);
    }
}
