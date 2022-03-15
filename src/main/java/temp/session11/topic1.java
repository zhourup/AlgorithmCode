package main.java.temp.session11;

/**
 * A:约数个数
 */
public class topic1 {

    public static void main(String[] args) {
        int num = 78120;
        System.out.println(countApproximate(num));
    }

    public static int countApproximate(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}
