package main.java.temp.session11;

/**
 * D:蛇形填数
 */
public class topic4 {

    public static void main(String[] args) {
        int count = 1;
        int num = 1;
        int level = 41;
        for (int i = 0; i < level; i++) {
            int j;
            for (j = 0; j < i; j++) {
                System.out.print(count + " ");
                count++;
            }
            if (j % 2 == 1) {
                System.out.print("num: " + num);
                num++;
            }
            System.out.println();
            //System.out.println("j:" + j);
        }
        System.out.println("result:"+761);
    }
}
