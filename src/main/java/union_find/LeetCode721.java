package main.java.union_find;

import java.util.*;

public class LeetCode721 {

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }

    public static void main(String[] args) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        int n = accounts.size();
        UnionFind myUnion = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int num = accounts.get(i).size();
            for (int j = 1; j < num; j++) {
                String curEmail = accounts.get(i).get(j);
                if (!emailToId.containsKey(curEmail)) {
                    emailToId.put(curEmail, i);
                } else {
                    myUnion.union(i, emailToId.get(curEmail));
                }
            }
        }

        // 进行完上面的步骤，同一个用户的所有邮箱已经属于同一个连通域了，但是就是在同一个连通域，不同的邮箱还是可能会对应不同的id

        //  将同一个连通域内的邮箱对应到同一个id
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            int id = myUnion.find(entry.getValue());
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(id, emails);
        }

        // 经过上面的步骤，已经做到了id和邮箱集合对应起来，接下来把用户名对应起来就可以了
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
    }
}
