//2022-10-08 10:12:20
//第1784题
//给你一个二进制字符串 s ，该字符串 不含前导零 。
//
// 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
//
// 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：s = "1001"
//输出：false
//解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
//
//
// 示例 2：
//
//
//输入：s = "110"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s[i] 为 '0' 或 '1'
// s[0] 为 '1'
//
//
// Related Topics 字符串 👍 68 👎 0

package leetcode.editor.cn;
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes{
    public static void main(String[] args){
        Solution solution = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        System.out.println(solution.checkOnesSegment("1001"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkOnesSegment(String s) {
        return s.split("0").length == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}