package temp.autumn.wangyimain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(in.nextInt());
        }
        System.out.println(getRes(nums, k, x));
    }

    private static int getRes(List<Integer> nums, int k, int x) {
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.addAll(nums);

        for (int i = temp.size() / 2; i > 0; i--) {
            adjust(temp, i, temp.size());
        }

        for (int i = k; i > 0; i--) {
            temp.set(1, temp.get(1) - x);
            adjust(temp, 1, temp.size());
        }
        return temp.get(1);
    }

    private static void adjust(List<Integer> list, int k, int len) {
        list.set(0, list.get(k));

        for (int i = 2 * k; i < len; i *= 2) {
            if (i + 1 < len && list.get(i) < list.get(i + 1)) {
                i++;
            }
            if (list.get(0) >= list.get(i)) {
                break;
            } else {
                list.set(k, list.get(i));
                k = i;
            }
        }
        list.set(k, list.get(0));
    }

}
