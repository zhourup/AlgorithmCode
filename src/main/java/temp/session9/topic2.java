package main.java.temp.session9;

/**
 * 方格计数
 */
public class topic2 {

    public static void main(String[] args) {
        int count = 0;
        int radius = 1000 * 1000;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int a = i + 1;
                int b = j + 1;
                if (a * a + b * b <= radius) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
