package temp.autumn.meituan;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(maxSanNum(a));
    }

    private static int maxSanNum(int[] nums) {
        int n = nums.length;
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i]+nums[k]==3*nums[j]){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
