//2023-01-13 14:01:36
//第2287题
//给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
//
// 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
//
//
//
// 示例 1：
//
// 输入：s = "ilovecodingonleetcode", target = "code"
//输出：2
//解释：
//对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
//对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
//形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
//可以形成最多 2 个 "code" 的副本，所以返回 2 。
//
//
// 示例 2：
//
// 输入：s = "abcba", target = "abc"
//输出：1
//解释：
//选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
//可以形成最多 1 个 "abc" 的副本，所以返回 1 。
//注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
//
//
// 示例 3：
//
// 输入：s = "abbaccaddaeea", target = "aaaaa"
//输出：1
//解释：
//选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
//可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// 1 <= target.length <= 10
// s 和 target 由小写英文字母组成
//
//
// Related Topics 哈希表 字符串 计数 👍 37 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetString{
    public static void main(String[] args){
        Solution solution = new RearrangeCharactersToMakeTargetString().new Solution();
        System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> charNum = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charNum.put(c, charNum.getOrDefault(c, 0)+1);
        }
        for (char c : target.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            ans = Math.min(ans, charNum.getOrDefault(entry.getKey(),0)/entry.getValue());
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}