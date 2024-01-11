//2024-01-11 09:04:51
//第2645题
//给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
//
// 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
//
//
//
// 示例 1：
//
// 输入：word = "b"
//输出：2
//解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
//
//
// 示例 2：
//
// 输入：word = "aaa"
//输出：6
//解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
//
//
// 示例 3：
//
// 输入：word = "abc"
//输出：0
//解释：word 已经是有效字符串，不需要进行修改。
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 50
// word 仅由字母 "a"、"b" 和 "c" 组成。
//
//
// Related Topics 栈 贪心 字符串 动态规划 👍 34 👎 0

package leetcode.editor.cn;
public class MinimumAdditionsToMakeValidString{
    public static void main(String[] args){
        Solution solution = new MinimumAdditionsToMakeValidString().new Solution();
        System.out.println(solution.addMinimum("b"));
        System.out.println(solution.addMinimum("aaa"));
        System.out.println(solution.addMinimum("abc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addMinimum(String word) {
        int ans = 0;
        char[] chars = word.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                ans += 2;
            }else if(i == len - 2){
                ans += chars[i+1] > chars[i] ? 1 : 4;
                i++;
            }else {
                if (chars[i+1] > chars[i]) {
                    if (chars[i+2] > chars[i+1]) {
                        i+=2;
                    }else {
                        ans++;
                        i++;
                    }
                }else {
                    ans += 2;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}