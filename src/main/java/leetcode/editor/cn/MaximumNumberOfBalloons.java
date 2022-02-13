//2022-02-13 11:44:03
//第1189题
//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 78 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons{
    public static void main(String[] args){
        Solution solution = new MaximumNumberOfBalloons().new Solution();
        System.out.println(solution.maxNumberOfBalloons("leetcode"));
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char aChar : chars) {
            charMap.put(aChar, charMap.getOrDefault(aChar, 0)+1);
        }
        return Math.min(charMap.getOrDefault('b', 0),
                Math.min(charMap.getOrDefault('a', 0),
                Math.min(charMap.getOrDefault('l', 0)/2,
                Math.min(charMap.getOrDefault('o', 0)/2, charMap.getOrDefault('n', 0)))));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}