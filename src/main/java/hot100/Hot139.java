package main.java.hot100;

import java.util.ArrayList;
import java.util.List;

public class Hot139 {

    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * 法一、动态规划、dp[i]表示字符串s前i个字符组成的字符串s[0...i-1]是否能被空格拆分成若干个字典中出现的单词
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[len];
    }
}
