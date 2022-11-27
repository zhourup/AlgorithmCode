package temp.autumn.wangyimain;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return b.compareTo(a);
        });
        for (int i = 0; i < n; i++) {
            pq.add(in.nextInt());
        }
        System.out.println(getRes(pq, k, x));
    }

    private static long getRes(PriorityQueue<Integer> pq, int k, int x) {
        for (int i = 0; i < k; i++) {
            Integer temp = pq.poll() - x;
            pq.add(temp);
        }

        return pq.peek();
    }


}
