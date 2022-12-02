package array;

/**
 * @author zhourup
 * @date 2022/12/2
 */
public class LeetCode1769 {

    public static void main(String[] args) {
        String s = "001011";
        int[] nums = minOperations1(s);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }


    /**
     * 法二
     * left[i]表示将左边所有的数都移动到当前下标盒子所需要的操作数
     * 此时cnt表示[0,i-1]中1的个数
     * 对于当前i位置left[i]=left[i-1]+cnt
     *
     * @param boxes
     * @return
     */
    public static int[] minOperations1(String boxes) {
        int n = boxes.length();
        char[] arr = boxes.toCharArray();


        int cnt1 = 0;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cnt1 += (arr[i] - '0');
                continue;
            }
            left[i] = left[i - 1] + cnt1;
            cnt1 += (arr[i] - '0');
        }

        int cnt2 = 0;
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                cnt2 += (arr[i] - '0');
                continue;
            }
            right[i] = right[i + 1] + cnt2;
            cnt2 += (arr[i] - '0');
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }

    public static int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = getValue(boxes, i);
        }
        return res;
    }

    /**
     * 法一
     * 求i左右的数都移动到i的总和
     *
     * @param s
     * @param i
     * @return
     */
    private static int getValue(String s, int i) {
        int sum = 0;
        // 左边的数
        for (int j = 0; j < i; j++) {
            int dist = (i - j) * (s.charAt(j) - '0');
            sum += dist;
        }

        // 右边的数
        for (int j = i + 1; j < s.length(); j++) {
            int dist = (j - i) * (s.charAt(j) - '0');
            sum += dist;
        }
        return sum;
    }
}
