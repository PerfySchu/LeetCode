//2024-09-05 09:48:54
//第3174题
//给你一个字符串 s 。
//
// 你的任务是重复以下操作删除 所有 数字字符：
//
//
// 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
//
//
// 请你返回删除所有数字字符以后剩下的字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "abc"
//
//
// 输出："abc"
//
// 解释：
//
// 字符串中没有数字。
//
//
// 示例 2：
//
//
// 输入：s = "cb34"
//
//
// 输出：""
//
// 解释：
//
// 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
//
// 然后对 s[1] 执行操作，s 变为 "" 。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含小写英文字母和数字字符。
// 输入保证所有数字都可以按以上操作被删除。
//
//
// Related Topics 栈 字符串 模拟 👍 11 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClearDigits{
    public static void main(String[] args){
        Solution solution = new ClearDigits().new Solution();
        System.out.println(solution.clearDigits("adc"));
        System.out.println(solution.clearDigits("cd34"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}