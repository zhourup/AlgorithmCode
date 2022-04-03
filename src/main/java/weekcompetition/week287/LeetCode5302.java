package main.java.weekcompetition.week287;

import java.util.*;

/**
 * @author zhourup
 * @date 2022/4/3 11:08
 */
public class LeetCode5302 {


    /**
     * 设计一个加密及解密下标从0开始字符串的数据结构
     */
    class Encrypter {

        private String[] keyToValue;
        private Map<String, Integer> dictCount;

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            keyToValue = new String[26];
            dictCount = new HashMap<>();
            int len = keys.length;
            for (int i = 0; i < len; i++) {
                int idx = keys[i] - 'a';
                keyToValue[idx] = values[i];
            }
            for (String s : dictionary) {
                //加密
                String encryptStr = encrypt(s);
                dictCount.put(encryptStr, dictCount.getOrDefault(encryptStr, 0) + 1);
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                String val = keyToValue[c - 'a'];
                sb.append(val);
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            return dictCount.getOrDefault(word2, 0);
        }
    }
}