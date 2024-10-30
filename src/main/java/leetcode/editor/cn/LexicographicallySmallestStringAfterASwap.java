//2024-10-30 09:34:44
//第3216题
//给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
//
// 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
//
//
//
// 示例 1：
//
//
// 输入： s = "45320"
//
//
// 输出： "43520"
//
// 解释：
//
// s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
//
// 示例 2：
//
//
// 输入： s = "001"
//
//
// 输出： "001"
//
// 解释：
//
// 无需进行交换，因为 s 已经是字典序最小的。
//
//
//
// 提示：
//
//
// 2 <= s.length <= 100
// s 仅由数字组成。
//
//
// Related Topics 贪心 字符串 👍 12 👎 0

package leetcode.editor.cn;
public class LexicographicallySmallestStringAfterASwap{
    public static void main(String[] args){
        Solution solution = new LexicographicallySmallestStringAfterASwap().new Solution();
        System.out.println(solution.getSmallestString("45320"));
        System.out.println(solution.getSmallestString("001"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        boolean odd = (chars[0]-'0') % 2 == 0;
        for (int i = 1; i < chars.length; i++) {
            boolean nextOdd = (chars[i] - '0') % 2 == 0;
            if ((odd && nextOdd || !odd &&!nextOdd) && chars[i] < chars[i-1]) {
                char temp = chars[i];
                chars[i] = chars[i-1];
                chars[i-1] = temp;
                break;
            }
            odd = nextOdd;
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}