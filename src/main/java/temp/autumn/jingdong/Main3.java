package temp.autumn.jingdong;

import java.util.*;

public class Main3 {

    //())())
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        map.put('(', ')');
        map.put('?', '?');
        System.out.println(getMaxNum(s));
    }

    static Map<Character, Character> map = new HashMap<>();

    private static int getMaxNum(String s) {
        List<String> subString = getSubStr(s);
        int res = 0;
        for (String s1 : subString) {
            res += getStringNum(s1);
        }
        return res;
    }

    private static List<String> getSubStr(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }

    private static int getStringNum(String s) {
        if (isValid(s)) {
            return s.length();
        }
        return 0;
    }

    private static boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
