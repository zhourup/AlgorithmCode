package main.java.weekcompetition.week65;

/**
 * @author zhourup
 * @date 2021/11/13 23:02
 */
public class LeetCode5911 {

    static class Robot {
        int[][] map;
        int currX;
        int currY;
        int currDir;
        String[] face = {"East", "North", "West", "South"};

        public Robot(int width, int height) {
            map = new int[width][height];
            currX = 0;
            currY = 0;
            currDir = 0;
        }

        public void move(int num) {
            while (num >= 0) {

            }
        }

        public int[] getPos() {
            return new int[]{currX, currY};
        }

        public String getDir() {
            return face[currDir];
        }
    }

    public static void main(String[] args) {

    }
}
