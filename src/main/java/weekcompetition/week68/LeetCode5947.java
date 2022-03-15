package main.java.weekcompetition.week68;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhourup
 * @date 2021/12/25 22:34
 */
public class LeetCode5947 {

    public static void main(String[] args) {
        String[] recipes = new String[]{"bread", "sandwich"};
        List<List<String>> ingredients = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("yeast");
        list1.add("flour");
        List<String> list2 = new ArrayList<>();
        list2.add("bread");
        list2.add("meat");
        ingredients.add(list1);
        ingredients.add(list2);
        String[] supplies = new String[]{"yeast", "flour", "meat"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String supplie : supplies) {
            set.add(supplie);
        }
        for (int i = 0; i < recipes.length; i++) {
            if (set.containsAll(ingredients.get(i))) {
                i += set.containsAll(ingredients.get(i)) && set.add(recipes[i]) && res.add(recipes[i]) ? -i : 1;
            }
        }
        return res;
    }
}
