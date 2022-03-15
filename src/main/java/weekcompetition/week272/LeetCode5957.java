package main.java.weekcompetition.week272;

/**
 * @author zhourup
 * @date 2021/12/19 10:36
 */
public class LeetCode5957 {

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] nums = new int[]{8, 13, 15};
        System.out.println(addSpaces(s, nums));
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for (int space : spaces) {
            sb.append(s.substring(pre, space));
            pre = space;
            sb.append(" ");
        }
        //添加最后一个单词
        sb.append(s.substring(spaces[spaces.length - 1]));
        return sb.toString();
    }
}
