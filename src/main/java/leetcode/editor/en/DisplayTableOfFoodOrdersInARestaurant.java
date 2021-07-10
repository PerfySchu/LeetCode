//Given the array orders, which represents the orders that customers have done i
//n a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItem
//i] where customerNamei is the name of the customer, tableNumberi is the table cu
//stomer sit at, and foodItemi is the item customer orders. 
//
// Return the restaurant's “display table”. The “display table” is a table whose
// row entries denote how many of each food item each table ordered. The first col
//umn is the table number and the remaining columns correspond to each food item i
//n alphabetical order. The first row should be a header whose first column is “Ta
//ble”, followed by the names of the food items. Note that the customer names are 
//not part of the table. Additionally, the rows should be sorted in numerically in
//creasing order. 
//
// 
// Example 1: 
//
// 
//Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["Davi
//d","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3
//","Ceviche"]]
//Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","
//2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]] 
//Explanation:
//The displaying table looks like:
//Table,Beef Burrito,Ceviche,Fried Chicken,Water
//3    ,0           ,2      ,1            ,0
//5    ,0           ,1      ,0            ,1
//10   ,1           ,0      ,0            ,0
//For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "
//Ceviche".
//For the table 5: Carla orders "Water" and "Ceviche".
//For the table 10: Corina orders "Beef Burrito". 
// 
//
// Example 2: 
//
// 
//Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"
//],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1
//","Canadian Waffles"]]
//Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0",
//"3"]] 
//Explanation: 
//For the table 1: Adam and Brianna order "Canadian Waffles".
//For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
// 
//
// Example 3: 
//
// 
//Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Me
//lissa","2","Soda"]]
//Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= orders.length <= 5 * 10^4 
// orders[i].length == 3 
// 1 <= customerNamei.length, foodItemi.length <= 20 
// customerNamei and foodItemi consist of lowercase and uppercase English letter
//s and the space character. 
// tableNumberi is a valid integer between 1 and 500. 
// Related Topics Array Hash Table String Sorting Ordered Set 
// 👍 133 👎 264

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisplayTableOfFoodOrdersInARestaurant{
    public static void main(String[] args){
        Solution solution = new DisplayTableOfFoodOrdersInARestaurant().new Solution();
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList("James","12","Fried Chicken"));
        orders.add(Arrays.asList("Ratesh","12","Fried Chicken"));
        orders.add(Arrays.asList("Adam","1","Canadian Waffles"));
        orders.add(Arrays.asList("Brianna","1","Canadian Waffles"));

        System.out.println(solution.displayTable(orders));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> foodList = new ArrayList<>();
        List<String> tableList = new ArrayList<>();
        for (List<String> order : orders) {
            if (!tableList.contains(order.get(1))) {
                tableList.add(order.get(1));
            }
            if (!foodList.contains(order.get(2))) {
                foodList.add(order.get(2));
            }
        }
        Collections.sort(foodList, String::compareTo);
        Collections.sort(tableList, Comparator.comparingInt(Integer::parseInt));
        foodList.add(0, "Table");
        tableList.add(0, "Table");

        List<List<String>> result = new ArrayList<>(tableList.size());
        result.add(foodList);
        for (int i = 1; i < tableList.size(); i++) {
            List<String> rowList = new ArrayList<>(foodList.size());
            rowList.add(tableList.get(i));
            for (int k = 1; k < foodList.size(); k++) {
                rowList.add("0");
            }
            result.add(rowList);
        }

        int row, col;
        for (List<String> order : orders) {
            row = tableList.indexOf(order.get(1));
            col = foodList.indexOf(order.get(2));
            result.get(row).set(col, Integer.parseInt(result.get(row).get(col))+1 + "");
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //网友 java8 纯流式解法
    public List<List<String>> func(List<List<String>> orders){
        //构建表头
        List<String> head = orders.stream().map(o -> o.get(2)).distinct().sorted()
                .collect(Collectors.toCollection(() -> Stream.of("Table").collect(Collectors.toList())));
        return orders.stream()
                .collect(Collectors.groupingBy(o -> Integer.parseInt(o.get(1)),
                        Collectors.groupingBy(o -> o.get(2), Collectors.counting())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> head.stream().skip(1).map(food -> entry.getValue().getOrDefault(food, 0L).toString())
                        .collect(Collectors.toCollection(() -> Stream.of(entry.getKey().toString()).collect(Collectors.toList()))))
                .collect(Collectors.toCollection(() -> Stream.of(head).collect(Collectors.toList())));
    }
}
