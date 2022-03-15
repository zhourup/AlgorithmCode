package main.java.others;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/30 14:45
 */
public class LeetCode460 {

    static class LFUCache {

        Map<Integer, Integer> keyToVal;
        Map<Integer, Integer> keyToFreq;
        Map<Integer, LinkedHashSet<Integer>> freqToKeys;
        int minFreq;
        int cap;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            minFreq = 0;
            cap = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            increaseKeyFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                increaseKeyFreq(key);
                return;
            }

            if (keyToVal.size() >= cap) {
                removeMinFreq();
            }
            insertNew(key, value);
        }

        private void insertNew(int key, int value) {
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            minFreq = 1;
        }

        private void removeMinFreq() {
            LinkedHashSet<Integer> freqList = freqToKeys.get(minFreq);
            int delKey = freqList.iterator().next();
            keyToVal.remove(delKey);
            keyToFreq.remove(delKey);
            freqList.remove(delKey);
            if (freqList.size() == 0) {
                freqToKeys.remove(minFreq);
            }
        }

        private void increaseKeyFreq(int key) {
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq).remove(key);
            freqToKeys.get(freq + 1).add(key);
            if (freqToKeys.get(freq).isEmpty()) {
                freqToKeys.remove(freq);
                if (freq == minFreq) {
                    minFreq++;
                }
            }
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1);
    }
}
