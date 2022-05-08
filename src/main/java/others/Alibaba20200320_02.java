package main.java.others;

import java.util.*;

/**
 * @author zhourup
 * @date 2022/3/24 16:21
 */
public class Alibaba20200320_02 {

    static class Node {
        String s;
        int len;

        public Node(String s, int len) {
            this.s = s;
            this.len = len;
        }
    }

    //dp[i]表示从字符'a'到最后一个字符的最大长度
    static int[] dp = new int[500];

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            Node node = new Node(tmp, tmp.length());
            nodeList.add(node);
        }
        //排序，字符串最后一个字母，由小到大，如果最后一个相同，按第一个字母由小到大排序
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.s.charAt(o1.len - 1) != o2.s.charAt(o2.len - 1)) {
                    return o1.s.charAt(o1.len - 1) - o2.s.charAt(o2.len - 1);
                } else {
                    return o1.s.charAt(0) - o2.s.charAt(0);
                }
            }
        });
        for (int i = 0; i < nodeList.size(); i++) {
            //第一位的ASCII码
            String str = nodeList.get(i).s;
            int start = str.charAt(0);
            int end = str.charAt(str.length() - 1);
            //必须从start开始到这循环到'a'
            for (int c = start; c >= 'a'; c--) {
                dp[end] = Math.max(dp[end], dp[c] + str.length());
            }
        }
        int ans = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }
}
