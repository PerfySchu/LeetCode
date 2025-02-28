//2025-02-28 13:46:47
//第2353题
//设计一个支持下述操作的食物评分系统：
//
//
// 修改 系统中列出的某种食物的评分。
// 返回系统中某一类烹饪方式下评分最高的食物。
//
//
// 实现 FoodRatings 类：
//
//
// FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由
//foods、cuisines 和 ratings 描述，长度均为 n 。
//
//
//
// foods[i] 是第 i 种食物的名字。
// cuisines[i] 是第 i 种食物的烹饪方式。
// ratings[i] 是第 i 种食物的最初评分。
//
//
// void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
// String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典
//序较小 的名字。
//
//
// 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] !=
//y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
//
//
//
// 示例：
//
// 输入
//["FoodRatings", "highestRated", "highestRated", "changeRating",
//"highestRated", "changeRating", "highestRated"]
//[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean",
//"japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], [
//"korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
//输出
//[null, "kimchi", "ramen", null, "sushi", null, "ramen"]
//
//解释
//FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi",
//"moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese",
// "korean"], [9, 12, 8, 15, 14, 7]);
//foodRatings.highestRated("korean"); // 返回 "kimchi"
//                                    // "kimchi" 是分数最高的韩式料理，评分为 9 。
//foodRatings.highestRated("japanese"); // 返回 "ramen"
//                                      // "ramen" 是分数最高的日式料理，评分为 14 。
//foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
//foodRatings.highestRated("japanese"); // 返回 "sushi"
//                                      // "sushi" 是分数最高的日式料理，评分为 16 。
//foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
//foodRatings.highestRated("japanese"); // 返回 "ramen"
//                                      // "sushi" 和 "ramen" 的评分都是 16 。
//                                      // 但是，"ramen" 的字典序比 "sushi" 更小。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 10⁴
// n == foods.length == cuisines.length == ratings.length
// 1 <= foods[i].length, cuisines[i].length <= 10
// foods[i]、cuisines[i] 由小写英文字母组成
// 1 <= ratings[i] <= 10⁸
// foods 中的所有字符串 互不相同
// 在对 changeRating 的所有调用中，food 是系统中食物的名字。
// 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
// 最多调用 changeRating 和 highestRated 总计 2 * 10⁴ 次
//
//
// Related Topics 设计 数组 哈希表 字符串 有序集合 堆（优先队列） 👍 53 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignAFoodRatingSystem{
    public static void main(String[] args){
        FoodRatings foodRatings = new DesignAFoodRatingSystem().new FoodRatings(
                new String[]{"tjokfmxg","xmiuwozpmj","uqklk","mnij","iwntdyqxi","cduc","cm","mzwfjk"},
                new String[]{"waxlau","ldpiabqb","ldpiabqb","waxlau","ldpiabqb","waxlau","waxlau","waxlau"},
                new int[]{9,13,7,16,10,17,16,17});
        //["tjokfmxg",19],["waxlau"],["uqklk",7],["waxlau"],["waxlau"],["tjokfmxg",14],["waxlau"],["waxlau"],["tjokfmxg",4],["waxlau"],["mnij",18],["waxlau"]]
        foodRatings.changeRating("tjokfmxg",19);
        System.out.println(foodRatings.highestRated("waxlau"));
        foodRatings.changeRating("uqklk",7);
        System.out.println(foodRatings.highestRated("waxlau"));
        System.out.println(foodRatings.highestRated("waxlau"));
        foodRatings.changeRating("tjokfmxg",14);
        System.out.println(foodRatings.highestRated("waxlau"));
        System.out.println(foodRatings.highestRated("waxlau"));
        foodRatings.changeRating("tjokfmxg",4);
        System.out.println(foodRatings.highestRated("waxlau"));
        foodRatings.changeRating("mnij",18);
        System.out.println(foodRatings.highestRated("waxlau"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class FoodRatings {
    Map<String, Node> foodMap;
    Map<String, PriorityQueue<Node>> cuisineMap;

    public class Node{
        String food;
        String cuisine;
        int rating;
        boolean delete;
        public Node(String food, String cuisine, int rating){
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
            this.delete = false;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Node node = new Node(foods[i],cuisines[i], ratings[i]);
            foodMap.put(foods[i], node);
            cuisineMap.computeIfAbsent(cuisines[i], k ->
                    new PriorityQueue<>((a, b) -> {
                        if (b.rating == a.rating) {
                            return a.food.compareTo(b.food);
                        }
                        return b.rating - a.rating;
                    })).add(node);
        }
    }

    public void changeRating(String food, int newRating) {
        foodMap.get(food).delete = true;
        String cuisine = foodMap.get(food).cuisine;
        Node newNode = new Node(food, cuisine, newRating);
        foodMap.put(food, newNode);
        cuisineMap.get(cuisine).add(newNode);
    }

    public String highestRated(String cuisine) {
        while(cuisineMap.get(cuisine).peek().delete){
            cuisineMap.get(cuisine).poll();
        }
        return cuisineMap.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
//leetcode submit region end(Prohibit modification and deletion)

}