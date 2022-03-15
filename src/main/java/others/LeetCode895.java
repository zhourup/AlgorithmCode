package main.java.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhourup
 * @date 2021/12/30 19:32
 */
public class LeetCode895 {

    static class FreqStack {

        Map<Integer, Integer> valToFreq;
        Map<Integer, Stack<Integer>> freqToVal;

        int maxFreq;

        public FreqStack() {
            valToFreq = new HashMap<>();
            freqToVal = new HashMap<>();
            maxFreq = 0;

        }

        public void push(int val) {
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            valToFreq.put(val, freq);
            freqToVal.putIfAbsent(freq, new Stack<>());
            freqToVal.get(freq).push(val);
            maxFreq = Math.max(maxFreq, freq);
        }

        public int pop() {
            Stack<Integer> stack = freqToVal.get(maxFreq);
            int res = stack.pop();
            if (maxFreq == 1) {
                valToFreq.remove(res);
                return res;
            }
            if (stack.size() == 0) {
                maxFreq--;
                valToFreq.put(res, maxFreq);
                return res;
            }
            valToFreq.put(res, maxFreq - 1);
            return res;
        }
    }

    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
    }


}
