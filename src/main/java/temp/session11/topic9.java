package main.java.temp.session11;

import java.util.HashMap;
import java.util.Scanner;

/**
 * I:子串分值
 */
public class topic9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(findAllSubstring(s));
    }


    public static int findAllSubstring(String s) {
        int result = 0;
        int len = s.length();
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                String s1 = s.substring(j, j + i);
                result = result + countNums(s1);
            }
        }
        return result;
    }

    public static int countNums(String s) {
        int count = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 1);
            } else {
                int val = hashMap.get(s.charAt(i)) + 1;
                hashMap.put(s.charAt(i), val);
            }
        }
        for (Integer value : hashMap.values()) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }

}
