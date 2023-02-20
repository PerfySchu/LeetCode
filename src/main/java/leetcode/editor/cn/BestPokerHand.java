//2023-02-20 10:20:19
//第2347题
//给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
//
// 下述是从好到坏你可能持有的 手牌类型 ：
//
//
// "Flush"：同花，五张相同花色的扑克牌。
// "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
// "Pair"：对子，两张大小一样的扑克牌。
// "High Card"：高牌，五张大小互不相同的扑克牌。
//
//
// 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
//
// 注意：返回的字符串 大小写 需与题目描述相同。
//
//
//
// 示例 1：
//
// 输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
//输出："Flush"
//解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
//
//
// 示例 2：
//
// 输入：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
//输出："Three of a Kind"
//解释：第一、二和四张牌组成三张相同大小的扑克牌，所以得到 "Three of a Kind" 。
//注意我们也可以得到 "Pair" ，但是 "Three of a Kind" 是更好的手牌类型。
//有其他的 3 张牌也可以组成 "Three of a Kind" 手牌类型。
//
// 示例 3：
//
// 输入：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
//输出："Pair"
//解释：第一和第二张牌大小相同，所以得到 "Pair" 。
//我们无法得到 "Flush" 或者 "Three of a Kind" 。
//
//
//
//
// 提示：
//
//
// ranks.length == suits.length == 5
// 1 <= ranks[i] <= 13
// 'a' <= suits[i] <= 'd'
// 任意两张扑克牌不会同时有相同的大小和花色。
//
//
// Related Topics 数组 哈希表 计数 👍 25 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand{
    public static void main(String[] args){
        Solution solution = new BestPokerHand().new Solution();
        System.out.println(solution.bestHand(new int[]{13,2,3,1,9}, new char[]{'a','a','a','a','a'}));
        System.out.println(solution.bestHand(new int[]{10,10,2,12,9}, new char[]{'a','b','c','a','d'}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        Map<Character, Integer> suitMap = new HashMap<>();
        int rankMax = 0;
        for (int rank : ranks) {
            int num = rankMap.getOrDefault(rank, 0) + 1;
            rankMax = Math.max(rankMax, num);
            rankMap.put(rank, num);
        }
        int suitMax = 0;
        for (char suit : suits) {
            int num = suitMap.getOrDefault(suit, 0) + 1;
            suitMax = Math.max(suitMax, num);
            suitMap.put(suit, num);
        }
        if (suitMax == 5) {
            return "Flush";
        }
        if (rankMax >= 3) {
            return "Three of a Kind";
        }
        if(rankMax >=2){
            return "Pair";
        }
        return "High Card";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}