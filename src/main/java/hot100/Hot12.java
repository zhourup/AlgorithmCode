package main.java.hot100;

public class Hot12 {

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));

    }

    /**
     * 法一、自己写的，不够简洁
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            num -= 1000;
            sb.append('M');
        }
        if (num >= 900) {
            num %= 900;
            sb.append("CM");
        }
        if (num >= 500) {
            num %= 500;
            sb.append('D');
        }
        if (num >= 400) {
            num %= 400;
            sb.append("CD");
        }
        while (num >= 100) {
            num -= 100;
            sb.append('C');
        }
        if (num >= 90) {
            num %= 90;
            sb.append("XC");
        }
        if (num >= 50) {
            num %= 50;
            sb.append('L');
        }
        if (num >= 40) {
            num %= 40;
            sb.append("XL");
        }
        while (num >= 10) {
            num -= 10;
            sb.append('X');
        }
        if (num >= 9) {
            num %= 9;
            sb.append("IX");
        }
        if (num >= 5) {
            num %= 5;
            sb.append('V');
        }
        if (num >= 4) {
            num %= 4;
            sb.append("IV");
        }
        while (num >= 1) {
            num -= 1;
            sb.append('I');
        }
        return sb.toString();
    }

    /**
     * 法二、模拟，比较简洁
     *
     * @param num
     * @return
     */
    public static String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
