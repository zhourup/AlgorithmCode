package main.java.binary_search;

/**
 * @author zhourup
 * @date 2022/1/3 14:58
 */
public class LeetCode1011 {

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 1, 1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }

    /**
     * 确定自变量x,f(x)和target
     * days明显就是target
     * x就是运载能力
     * f(X)就是运载能力为x时，将包裹全部运载完所需时间
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays(int[] weights, int days) {
        //确定k的左边界和右边界，开始二分查找
        int left = 0, right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = getLoadTime(weights, mid);
            if (time == days) {
                //让mid更小
                right = mid - 1;
            } else if (time > days) {
                //让time更小
                left = mid + 1;
            } else if (time < days) {
                //让time更大，k越小，time越大=》让k小
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回运载能力为k时所需的时间
     *
     * @param weights
     * @param k
     * @return
     */
    private static int getLoadTime(int[] weights, int k) {
        int time = 1;
        int tmp = k;
        for (int weight : weights) {
            if (tmp < weight) {
                tmp = k;
                time++;
            }
            tmp = tmp - weight;
        }
        return time;
    }
}
