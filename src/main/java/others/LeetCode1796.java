package others;

/**
 * @author zhourup
 * @date 2022/12/3
 */
public class LeetCode1796 {

    public static void main(String[] args) {
        String s = "dfa12321afd";
        System.out.println(secondHighest(s));
    }


    public static int secondHighest(String s) {
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }

        return second;
    }

}
