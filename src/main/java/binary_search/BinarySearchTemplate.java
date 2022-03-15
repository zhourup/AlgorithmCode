package main.java.binary_search;

/**
 * 全部写成左闭右闭的形式，方便记忆
 *
 * @author zhourup
 * @date 2021/12/4 22:26
 */
public class BinarySearchTemplate {

    /**
     * 查找=target的元素下标索引,数组中无target则返回-1
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 当target比所有元素都大时，left会被加到nums.length，所以要防止越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找右侧边界的二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 当target比所有元素都小时，right会被减到-1，所以需要防止越界
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
