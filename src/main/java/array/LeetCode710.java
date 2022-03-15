package main.java.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhourup
 * @date 2022/1/4 12:41
 */
public class LeetCode710 {

    /**
     * 思路：我们可以将区间[0,N)看做一个数组，然后将blacklist中的元素移到数组的最末尾，同时用一个哈希表进行映射
     * 把黑名单中的数组都交换到区间[sz,N)，同时把[0,sz)中的黑名单数字映射到了正常数字
     */
    static class Solution {
        int sz;
        Map<Integer, Integer> map;
        Random random = new Random();

        public Solution(int n, int[] blacklist) {
            //最终数组的元素个数
            sz = n - blacklist.length;
            map = new HashMap<>();

            //先把所有的黑名单数字加入map
            for (int b : blacklist) {
                map.put(b, 666);
            }

            int last = n - 1;
            for (int b : blacklist) {
                //如果b已经在区间[sz,N)，可以直接忽略
                if (b >= sz) {
                    continue;
                }
                while (map.containsKey(last)) {
                    last--;
                }
                //将黑名单中的索引映射到合法数字
                map.put(b, last);
                last--;
            }
        }

        public int pick() {
            int index = random.nextInt(sz);
            //如果这个索引命中了黑名单，需要被映射到其他位置
            if (map.containsKey(index)) {
                return map.get(index);
            }
            //没有命中黑名单，直接返回
            return index;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] nums = new int[]{2};
        Solution obj = new Solution(n, nums);
        System.out.println(obj.pick());
        System.out.println(obj.pick());
        System.out.println(obj.pick());
    }
}
