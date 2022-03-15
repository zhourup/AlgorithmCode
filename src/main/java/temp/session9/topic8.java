package main.java.temp.session9;

import java.util.*;

/**
 * 日志统计
 */
public class topic8 {
    private static class User {
        int id;
        List<Integer> tList;

        public User(int id) {
            this.id = id;
            tList = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Map<Integer, User> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            int ts = in.nextInt();
            int id = in.nextInt();
            if (map.get(id) != null) {
                map.get(id).tList.add(ts);
            } else {
                User user = new User(id);
                user.tList.add(ts);
                map.put(id, user);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (isHotPost(map.get(key), d, k)) {
                res.add(key);
            }
        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        in.close();
    }

    private static boolean isHotPost(User user, int d, int k) {
        List<Integer> records = new ArrayList<>();
        records = user.tList;
        Collections.sort(records);
        if (records.size() >= k) {
            for (int i = 0; i <= records.size() - k; i++) {
                if (records.get(i + k - 1) - records.get(i) < d) {
                    return true;
                }
            }
        }
        return false;
    }
}
