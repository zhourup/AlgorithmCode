package main.java.heap;

public class LeetCode215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        printHeap(nums);
        System.out.println();
        System.out.println(findKthLargest(nums, 5000));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int heapSort(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > nums.length - k) {
            heapIfy(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
        return nums[nums.length - k];
    }

    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapIfy(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(nums, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void printHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        return heapSort(nums, k);
    }
}
