package main.java.double_pointer;

import java.util.Arrays;

public class LeetCode881 {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            count++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }
        return count;
    }

    public static int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            count++;
        }
        return count;
    }
}
