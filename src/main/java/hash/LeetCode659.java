package main.java.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2022/5/2 21:38
 */
public class LeetCode659 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(isPossible(nums));
    }

    /**
     * 两种情况：
     * 1、当前v自成一派，以自己为头构成长度至少为3的序列
     * 2、当前元素v接到已经存在的子序列后面
     * 策略：优先判断自己能否接到其他序列后面，如果不行，再判断是否可以作为新的子序列开头
     * freq哈希表帮助一个元素判断自己是否能作为开头
     * freq记录每个元素出现的次数，如果freq[3],freq[4],freq[5]都大于0，说明元素3可以作为开头组成一个长度为3的子序列
     * <p>
     * need哈希表帮助一个元素判断自己是否可以被接到其他序列后面
     * need记录哪些元素可以被接到其他子序列后面
     * 如果现在已经组成了[1,2,3,4]和[2,3,4]，那么need[5]的值就应该是2，说明对元素5的需求为2
     *
     * @param nums
     * @return
     */
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        //统计nums中元素的频率
        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        for (int v : nums) {
            if (freq.get(v) == 0) {
                continue;
            }
            //先判断v是否能接到其他子序列后面
            if (need.containsKey(v) && need.get(v) > 0) {
                //v可以接到之前的某个序列后面
                freq.put(v, freq.get(v) - 1);
                //随便取一个需要v的子序列，把v接到这个子序列后面，这个子序列的需求就变成了v+1
                need.put(v, need.get(v) - 1);
                need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);

                //再判断能否以自己为开头建立一个长度为3的子序列
            } else if (freq.containsKey(v) && freq.containsKey(v + 1) && freq.containsKey(v + 2)
                    && freq.get(v) > 0 && freq.get(v + 1) > 0 && freq.get(v + 2) > 0) {
                //将v作为开头，新建一个长度为3的子序列[v,v+1,v+2]
                freq.put(v, freq.get(v) - 1);
                freq.put(v + 1, freq.get(v + 1) - 1);
                freq.put(v + 2, freq.get(v + 2) - 1);
                need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
            } else {
                //两种情况都不符合，则无法分配
                return false;
            }
        }
        return true;
    }
}
