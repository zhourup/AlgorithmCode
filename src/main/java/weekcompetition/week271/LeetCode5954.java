package main.java.weekcompetition.week271;

/**
 * @author zhourup
 * @date 2021/12/12 11:10
 */
public class LeetCode5954 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,4,5};
        int A = 6;
        int B = 5;
        System.out.println(minimumRefill(nums, A, B));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int left = 0, right = n - 1;
        int currA = capacityA, currB = capacityB;
        int count = 0;
        while (left <= right) {
            if (left == right) {
                //当两个人同时到达一株植物处时
                int maxW = Math.max(currA, currB);
                if (maxW < plants[left]) {
                    count++;
                }
                left++;
            } else {
                if (currA < plants[left]) {
                    currA = capacityA;
                    count++;
                }
                currA -= plants[left++];
                if (currB < plants[right]) {
                    currB = capacityB;
                    count++;
                }
                currB -= plants[right--];
            }
        }
        return count;
    }
}
