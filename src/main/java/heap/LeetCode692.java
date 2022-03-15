package main.java.heap;

import java.util.*;

public class LeetCode692 {

    public static class nodeComparator implements Comparator<node> {

        @Override
        public int compare(node o1, node o2) {
            if (o1.val != o2.val) {
                return o2.val - o1.val;
            } else {
                return o1.name.compareTo(o2.name);
            }
        }
    }

    private static class node {
        int val;
        String name;

        public node(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> list;
        list = topKFrequent1(words, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    /**
     * 法一：先排序，再取前k个
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        List<node> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        for (String key : map.keySet()) {
            list.add(new node(key, map.get(key)));
        }
        Collections.sort(list, new nodeComparator());
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).name);
        }
        return res;
    }

    /**
     * 法二：堆
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>(count.keySet());
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (count.get(o1).equals(count.get(o2))) {
                    return o1.compareTo(o2);
                } else {
                    return count.get(o2) - count.get(o1);
                }
            }
        });
        return res.subList(0, k);
    }

}
