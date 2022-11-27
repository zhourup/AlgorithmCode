package temp.autumn.oppo;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        int[] nums = {3, 4};
        System.out.println(maxDigit(nums));
    }

    public static int maxDigit(int[] digits) {
        String[] strs = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            strs[i] = String.valueOf(digits[i]);
        }

        Arrays.sort(strs, (String a, String b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });

        if (strs[0].equals("0")) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return Integer.parseInt(sb.toString());
    }
}
