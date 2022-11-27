package temp.autumn.ant;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(getValue(s));
    }

    private static int getValue(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isGoodStr(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isGoodStr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ji = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                ji++;
            }
            if (ji > 1) {
                return false;
            }
        }
        return ji == 1;
    }
}
