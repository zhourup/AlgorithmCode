package main.java.weekcompetition.week268;

/**
 * @author zhourup
 * @date 2021/11/21 10:30
 */
public class LeetCode5930 {

    public static void main(String[] args) {

        int[] num = {0, 1};
        System.out.println(maxDistance(num));
    }

    public static int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = colors.length - 1; j >= i; j--) {
                if (colors[j] != colors[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
