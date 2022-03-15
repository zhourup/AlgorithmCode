package main.java.hot100;

import java.util.*;

public class Hot49 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 法一、利用哈希表
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String tmp = sortString(strs[i]);
            if (map.containsKey(tmp)) {
                List<String> stoList = map.get(tmp);
                stoList.add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(tmp, newList);
            }
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
