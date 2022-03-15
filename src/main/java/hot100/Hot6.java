package main.java.hot100;

import java.util.ArrayList;
import java.util.List;

public class Hot6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert3(s, numRows));


    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        //最开始增加的长度
        int count = (numRows - 1) * 2;
        int len = count;
        int current = 0;
        int cycle = 1;
        int temp = 0;
        while (sb.length() != s.length()) {
            temp = 0;
            while (current < s.length()) {
                if ((len == count - 2) && temp % 2 == 1) {
                    System.out.println("current:" + current + " " + s.charAt(current) + " temp:" + temp);
                    sb.append(s.charAt(current));
                    current = current + 2;
                } else {
                    System.out.println("current:" + current + " " + s.charAt(current) + " temp:" + temp);
                    sb.append(s.charAt(current));
                    current = current + len;
                }
                temp++;
            }
            current = cycle++;
            len = len - 2;
            if (len == 0) {
                len = count;
            }

        }
        return sb.toString();
    }

    /**
     * 法一、按行排序 时间和空间都是O(N)
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * 法二、按行访问,时间和空间都是O(N)  PAYPALISHIRING
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public static String convert3(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            row += goDown ? -1 : 1;
            if (row == 0 || row == numRows - 1) {
                goDown = !goDown;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            ret.append(rows.get(i));
        }
        return ret.toString();
    }
}
