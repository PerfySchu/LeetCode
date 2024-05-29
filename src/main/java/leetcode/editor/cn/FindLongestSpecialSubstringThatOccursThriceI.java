//2024-05-29 10:43:27
//第2981题
//给你一个仅由小写英文字母组成的字符串 s 。
//
// 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
//符串。
//
// 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
//
// 子字符串 是字符串中的一个连续 非空 字符序列。
//
//
//
// 示例 1：
//
//
//输入：s = "aaaa"
//输出：2
//解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
//可以证明最大长度是 2 。
//
//
// 示例 2：
//
//
//输入：s = "abcdef"
//输出：-1
//解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
//
//
// 示例 3：
//
//
//输入：s = "abcaba"
//输出：1
//解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
//可以证明最大长度是 1 。
//
//
//
//
// 提示：
//
//
// 3 <= s.length <= 50
// s 仅由小写英文字母组成。
//
//
// Related Topics 哈希表 字符串 二分查找 计数 滑动窗口 👍 21 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI{
    public static void main(String[] args){
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceI().new Solution();
        System.out.println(solution.maximumLength("aaaa"));
        System.out.println(solution.maximumLength("abcdef"));
        System.out.println(solution.maximumLength("abcaba"));
        System.out.println(solution.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        int ans = -1;
        Map<String, Integer> subMap = new HashMap<>();
        int maxLen = s.length() - 2;
        for (int i = 1; i <= maxLen; i++) {
            for (int idx = 0; idx < s.length() - i + 1; idx++) {
                String substring = s.substring(idx, idx+i);
                if (!isSameChar(substring)) {
                    continue;
                }
                subMap.put(substring, subMap.getOrDefault(substring, 0)+1);
            }
        }
        for (Map.Entry<String, Integer> entry : subMap.entrySet()) {
            if(entry.getValue() >= 3){
                ans = Math.max(entry.getKey().length(), ans);
            }
        }
        return ans;
    }

    private boolean isSameChar(String str){
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}