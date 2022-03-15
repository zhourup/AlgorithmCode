package main.java.hash;

import java.util.Arrays;

public class LeetCode705 {

    private static int[] nums;
    private static final int SIZE = 10000;
    private static final int NULL = -1;
    private static final int DELETED = -2;


    public static void main(String[] args) {

    }

    public LeetCode705() {
        nums = new int[SIZE];
        Arrays.fill(nums, NULL);
    }

    public void add(int key) {
        nums[hash(key)] = key;
    }

    public void remove(int key) {
        nums[hash(key)] = DELETED;
    }

    public boolean contains(int key) {
        return nums[hash(key)] != NULL;
    }

    private int hash(int key) {
        int i = key % SIZE;
        while (nums[i] != key && nums[i] != NULL) {
            i = (i + 1) % SIZE;
        }
        return i;
    }
}
