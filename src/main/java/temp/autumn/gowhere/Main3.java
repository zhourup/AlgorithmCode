package temp.autumn.gowhere;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
//        System.out.println(showDown("SA SK SQ SJ S10 H10 C9"));
        System.out.println(showDown("S3 S3 S3 S2 S2"));
    }

    public static String showDown(String inHand) {
        String s1 = "HuangJiaTongHuaShun";
        String s2 = "TongHuaShun";
        String s3 = "SiTiao";
        String s4 = "HuLu";
        String s5 = "TongHua";
        String s6 = "ShunZi";
        String s7 = "SanTiao";
        String s8 = "LiangDui";
        String s9 = "YiDui";

        String[] ps = inHand.split(" ");

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s : ps) {
            String c1 = s.substring(0,1);
            String c2 = s.substring(1);
            map.put(c2, map.getOrDefault(c2, 0) + 1);
            set.add(c2);
        }

        if (map.size() == 2) {
            if (map.containsValue(4) && map.containsValue(1)) {
                return s3;
            }
            if (map.containsValue(3) && map.containsValue(2)) {
                return s4;
            }
        }
        if (map.size()==3){
            if (map.containsValue(3)){
                return s7;
            }
            if (map.containsValue(2)&&map.containsValue(1)){
                return s8;
            }
        }
        if (set.size() == 1) {
            return s5;
        }
        return s1;
    }
}
