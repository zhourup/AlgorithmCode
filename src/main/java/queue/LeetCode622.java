package main.java.queue;

public class LeetCode622 {
    int[] nums;
    int count = 0;
    int front = 0;
    int rear = 0;
    int size;

    public static void main(String[] args) {
        LeetCode622 circularQueue = new LeetCode622(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }

    public LeetCode622(int k) {
        size = k;
        nums = new int[k];
    }

    public boolean enQueue(int value) {
        if (count < size) {
            nums[rear % size] = value;
            rear = (rear + 1) % size;
            count++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (count > 0) {
            front = (front + 1) % size;
            count--;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        if (count > 0) {
            return nums[front % size];
        } else {
            return -1;
        }
    }

    public int Rear() {
        if (count > 0) {
            return nums[(rear + size - 1) % size];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
