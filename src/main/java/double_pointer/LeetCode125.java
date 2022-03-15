package main.java.double_pointer;

public class LeetCode125 {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    /**
     * 方法一，双指针法
     *
     * @param s s
     * @return result
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right >= left) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (right >= left && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    /**
     * 方法二，将字母，数字存放到新的数组中，再判断
     *
     * @param s s
     * @return result
     */
    public static boolean isPalindrome1(String s) {
        if (s.equals("")) return true;
        char[] temp = s.toLowerCase().toCharArray();
        char[] str = new char[temp.length];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if ((temp[i] >= 'a' && temp[i] <= 'z') || (temp[i] >= '0' && temp[i] <= '9'))
                str[j++] = temp[i];
        }
        int i;
        for (i = 0; i < j / 2; i++) {
            if (str[i] != str[j - i - 1]) break;
        }
        if (i == j / 2) return true;
        return false;
    }
}
