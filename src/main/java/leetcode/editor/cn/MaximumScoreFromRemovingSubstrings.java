//2025-07-23 13:38:10
//第1717题
//给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
//
//
// 删除子字符串 "ab" 并得到 x 分。
//
//
//
// 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
//
//
// 删除子字符串"ba" 并得到 y 分。
//
// 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
//
//
//
//
// 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
//
//
//
// 示例 1：
//
// 输入：s = "cdbcbbaaabab", x = 4, y = 5
//输出：19
//解释：
//- 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
//- 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
//- 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
//- 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
//总得分为 5 + 4 + 5 + 5 = 19 。
//
// 示例 2：
//
// 输入：s = "aabbaaxybbaabb", x = 5, y = 4
//输出：20
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// 1 <= x, y <= 10⁴
// s 只包含小写英文字母。
//
//
// Related Topics 栈 贪心 字符串 👍 59 👎 0

package leetcode.editor.cn;
public class MaximumScoreFromRemovingSubstrings{
    public static void main(String[] args){
        Solution solution = new MaximumScoreFromRemovingSubstrings().new Solution();
        System.out.println(solution.maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(solution.maximumGain("aabbaaxybbaabb", 5, 4));
        System.out.println(solution.maximumGain("aabbaaxybbaabb", 4, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = s.replace('a', '\0').replace('b', 'a').replace('\0', 'b');
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cntA = 0, cntB = 0;
            while (i < s.length() && (s.charAt(i) == 'a' || s.charAt(i) == 'b')) {
                char c = s.charAt(i++);
                if (c == 'a'){
                    cntA++;
                }
                else {
                    if (cntA > 0) {
                        cntA--;
                        ans += x;
                    } else {
                        cntB++;
                    }
                }
            }
            ans += Math.min(cntA, cntB) * y;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}