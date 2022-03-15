package main.java.hot100;

public class Hot11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(height));
    }

    /**
     * 法一、暴力解法O(N^2) 可能超出时间限制
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = j - i;
                int h = height[i] > height[j] ? height[j] : height[i];
                if (len * h > max) {
                    max = len * h;
                }
            }
        }
        return max;
    }

    /**
     * 法二、双指针 O(N)
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int len = right - left;
            int h = height[left] > height[right] ? height[right] : height[left];
            int area = len * h;
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
