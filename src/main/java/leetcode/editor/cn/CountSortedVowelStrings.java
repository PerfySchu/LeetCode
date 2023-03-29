//2023-03-29 11:01:53
//第1641题
//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
//
//
// 示例 3：
//
//
//输入：n = 33
//输出：66045
//
//
//
//
// 提示：
//
//
// 1 <= n <= 50
//
//
// Related Topics 数学 动态规划 组合数学 👍 115 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class CountSortedVowelStrings{
    public static void main(String[] args){
        Solution solution = new CountSortedVowelStrings().new Solution();
        System.out.println(solution.countVowelStrings(1));
        System.out.println(solution.countVowelStrings(2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0];    // a前只能是a
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];     // b前可以是a和b
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
        }
        return Arrays.stream(dp[n - 1]).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}