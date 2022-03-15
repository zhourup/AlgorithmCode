package main.java.queue;

public class LeetCode641 {
    int[] nums;
    int count = 0;
    int front = 0;
    int rear = 0;
    int size;

    public static void main(String[] args) {
        LeetCode641 circularDeque = new LeetCode641(5); // 设置容量大小为3
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.insertLast(0));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println("执行完成");
    }

    public LeetCode641(int k) {
        size = k;
        nums = new int[size];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (count < size) {
            front = (front - 1 + size) % size;
            nums[front] = value;
            count++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (count < size) {
            nums[rear] = value;
            rear = (rear + 1) % size;
            count++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (count > 0) {
            front = (front + 1) % size;
            count--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count > 0) {
            rear = (rear + size - 1) % size;
            count--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (count > 0) {
            return nums[front];
        } else {
            return -1;
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count > 0) {
            return nums[(rear - 1 + size) % size];
        } else {
            return -1;
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == size;
    }
}
