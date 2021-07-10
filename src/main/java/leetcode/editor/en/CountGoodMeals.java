//A good meal is a meal that contains exactly two different food items with a su
//m of deliciousness equal to a power of two. 
//
// You can pick any two different foods to make a good meal. 
//
// Given an array of integers deliciousness where deliciousness[i] is the delici
//ousness of the ith item of food, return the number of different good meals you c
//an make from this list modulo 109 + 7. 
//
// Note that items with different indices are considered different even if they 
//have the same deliciousness value. 
//
// 
// Example 1: 
//
// 
//Input: deliciousness = [1,3,5,7,9]
//Output: 4
//Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
//Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
// 
//
// Example 2: 
//
// 
//Input: deliciousness = [1,1,1,3,3,3,7]
//Output: 15
//Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7
//) with 3 ways. 
//
// 
// Constraints: 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics Array Hash Table 
// 👍 319 👎 150

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals{
    public static void main(String[] args){
        Solution solution = new CountGoodMeals().new Solution();
        System.out.println(solution.countPairs(new int[]{2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(int[] deliciousness) {
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= 1<<21; sum<<=1) {
                count += map.getOrDefault(sum-val,0);
                count %= 1000000007;
            }
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
