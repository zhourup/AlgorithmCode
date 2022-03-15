package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/25 22:35
 */
public class Hot621 {

    public static void main(String[] args) {
        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(chars, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        int ret = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                ret++;
            }
        }
        return Math.max(ret, tasks.length);
    }
}
