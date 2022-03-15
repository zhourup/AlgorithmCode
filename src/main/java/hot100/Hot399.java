package main.java.hot100;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/11/12 15:24
 */
public class Hot399 {

    public static void main(String[] args) {
//        List<List<String>> equations = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        equations.add(list1);
//        List<String> list2 = new ArrayList<>();
//        list2.add("b");
//        list2.add("c");
//        equations.add(list2);
//        double[] nums = {2.0, 3.0};
//        List<List<String>> queries = new ArrayList<>();
//        List<String> list3 = new ArrayList<>();
//        list3.add("a");
//        list3.add("c");
//        queries.add(list3);
//        List<String> list4 = new ArrayList<>();
//        list4.add("b");
//        list4.add("a");
//        queries.add(list4);
//
//        List<String> list5 = new ArrayList<>();
//        list5.add("a");
//        list5.add("e");
//        queries.add(list5);
//
//        List<String> list6 = new ArrayList<>();
//        list6.add("a");
//        list6.add("a");
//        queries.add(list6);
//
//        List<String> list7 = new ArrayList<>();
//        list7.add("x");
//        list7.add("x");
//        queries.add(list7);

//        List<List<String>> equations = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        equations.add(list1);
//        List<String> list2 = new ArrayList<>();
//        list2.add("b");
//        list2.add("c");
//        equations.add(list2);
//        List<String> list21 = new ArrayList<>();
//        list21.add("bc");
//        list21.add("cd");
//        equations.add(list21);
//        double[] nums = {1.5, 2.5, 5.0};
//        List<List<String>> queries = new ArrayList<>();
//        List<String> list3 = new ArrayList<>();
//        list3.add("a");
//        list3.add("c");
//        queries.add(list3);
//        List<String> list4 = new ArrayList<>();
//        list4.add("c");
//        list4.add("b");
//        queries.add(list4);
//
//        List<String> list5 = new ArrayList<>();
//        list5.add("bc");
//        list5.add("cd");
//        queries.add(list5);
//
//        List<String> list6 = new ArrayList<>();
//        list6.add("cd");
//        list6.add("bc");
//        queries.add(list6);

//        List<List<String>> equations = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        equations.add(list1);
//        double[] nums = {0.5};
//        List<List<String>> queries = new ArrayList<>();
//        List<String> list3 = new ArrayList<>();
//        list3.add("a");
//        list3.add("b");
//        queries.add(list3);
//        List<String> list4 = new ArrayList<>();
//        list4.add("b");
//        list4.add("a");
//        queries.add(list4);
//
//        List<String> list5 = new ArrayList<>();
//        list5.add("a");
//        list5.add("c");
//        queries.add(list5);
//
//        List<String> list6 = new ArrayList<>();
//        list6.add("x");
//        list6.add("y");
//        queries.add(list6);

        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("e");
        equations.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("e");
        equations.add(list2);
        double[] nums = {4.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        queries.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("e");
        list4.add("e");
        queries.add(list4);

        List<String> list5 = new ArrayList<>();
        list5.add("x");
        list5.add("x");
        queries.add(list5);

        double[] res = calcEquation(equations, nums, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}
