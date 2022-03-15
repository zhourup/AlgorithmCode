package main.java.str;

import java.util.Scanner;

public class LeetCode709 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(toLowerCase1(str));
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static String toLowerCase1(String str) {
        if (str==null||str.length()==0){
            return str;
        }
        StringBuilder sb=new StringBuilder();
        for (char c:str.toCharArray()){
            if (c>='A'&&c<='Z'){
                sb.append((char) (c+32));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
