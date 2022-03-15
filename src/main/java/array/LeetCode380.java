package main.java.array;

import java.util.*;

/**
 * @author zhourup
 * @date 2022/1/4 12:39
 */
public class LeetCode380 {

    static class RandomizedSet {

        //记录数-索引
        Map<Integer, Integer> map;
        List<Integer> nums;
        Random random = new Random();

        public RandomizedSet() {
            map = new HashMap<>();
            nums = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, map.size());
            nums.add(nums.size(), val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            //先将要删除的val和末尾的val交换，再将末尾的val删除
            int lastE = nums.get(map.size() - 1);
            int valIndex = map.get(val);
            nums.set(valIndex, lastE);
            map.put(lastE, valIndex);
            nums.remove(map.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(map.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        System.out.println(randomizedSet.remove(2));
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
    }
}
