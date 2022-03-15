package main.java.notes;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class Code_03_Print_All_Subsequences {

    public static void printAllSub(char[] str,int i,String res){
        if (i==str.length){
            System.out.println(res);
            return;
        }
        printAllSub(str,i+1,res);
        printAllSub(str,i+1,res+String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        String test="abc";
        printAllSub(test.toCharArray(),0,"");
    }
}
