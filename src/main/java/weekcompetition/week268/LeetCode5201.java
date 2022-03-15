package main.java.weekcompetition.week268;

/**
 * @author zhourup
 * @date 2021/11/21 10:42
 */
public class LeetCode5201 {

    public static void main(String[] args) {
        int[] plants = {7, 7, 7, 7, 7, 7, 7};
        int capacity = 8;
        System.out.println(wateringPlants(plants, capacity));

    }

    public static int wateringPlants(int[] plants, int capacity) {
        int len = plants.length;
        boolean[] flags = new boolean[len];
        int count = 0;
        int currW = capacity;
        int index = 0;
        while (index < len) {
            if (!flags[index]) {
                //还未浇水
                if (currW >= plants[index]) {
                    //剩余水可以浇完
                    currW -= plants[index];
                    flags[index++] = true;
                    count++;
                } else {
                    //剩余水浇不完
                    count += index;
                    currW = capacity;
                    index = 0;
                }
            } else {
                //浇水了
                index++;
                count++;
            }
        }
        return count;
    }
}
