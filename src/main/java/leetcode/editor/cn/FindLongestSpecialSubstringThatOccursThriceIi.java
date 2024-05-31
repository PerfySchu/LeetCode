//2024-05-30 09:29:15
//第2982题
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
// 3 <= s.length <= 5 * 10⁵
// s 仅由小写英文字母组成。
//
//
// Related Topics 哈希表 字符串 二分查找 计数 滑动窗口 👍 12 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceIi{
    public static void main(String[] args){
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceIi().new Solution();
        //System.out.println(solution.maximumLength("aaaa"));
        //System.out.println(solution.maximumLength("abcdef"));
        //System.out.println(solution.maximumLength("abcaba"));
        System.out.println(solution.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<Character, List<Integer>> cnt = new HashMap<>();

        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            cnt.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(j - i);
        }

        int res = -1;
        for (List<Integer> vec : cnt.values()) {
            int lo = 1, hi = n - 2;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                int count = 0;
                for (int x : vec) {
                    if (x >= mid) {
                        count += x - mid + 1;
                    }
                }
                if (count >= 3) {
                    res = Math.max(res, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}