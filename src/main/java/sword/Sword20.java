package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/13 17:15
 */
public class Sword20 {

    public static void main(String[] args) {
        String s = "    awfawfawfawf!awfawfawf     ";
        System.out.println(s.trim());
    }


    public boolean isNumber(String s) {
        s = s.trim();
        if (isDecimal(s) || isInteger(s)) {
            return true;
        }
        return false;
    }

    public boolean isDecimal(String s) {

        return false;
    }

    public boolean isInteger(String s) {
        return false;
    }
}
