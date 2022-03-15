package main.java.weekcompetition.week68;

/**
 * @author zhourup
 * @date 2021/12/25 22:30
 */
public class LeetCode5946 {

    public static void main(String[] args) {
        String[] words = new String[]{"please wait", "continue to fight", "continue to win"};
        System.out.println(mostWordsFound(words));
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            max = Math.max(max, words.length);
        }
        return max;
    }
}
