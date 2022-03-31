package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 17:40
 */
public class Sword58I {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            sb.append(strs[i] + " ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}
