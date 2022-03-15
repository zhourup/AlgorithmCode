package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/10 20:16
 */
public class Sword11 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(minArray(nums));
    }

    /**
     * O(N)
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0, center = 0, right = 0;
        while (left < n) {
            while (center < n && numbers[center] == numbers[left]) {
                center++;
            }
            if (center == n) {
                return numbers[0];
            }
            while (right < n && numbers[right] == numbers[center]) {
                right++;
            }
            if (numbers[center] < numbers[left] && numbers[center] < numbers[right]) {
                return numbers[center];
            }
            left = center;
        }
        return 0;
    }

    /**
     * 二分法O(logn)
     *
     * @param numbers
     * @return
     */
    public static int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
