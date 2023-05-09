//2023-05-09 11:32:15
//第2437题
//给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是
//"23:59" 。
//
// 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
//
// 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
//
//
//
// 示例 1：
//
// 输入：time = "?5:00"
//输出：2
//解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所
//以我们有两个选择。
//
//
// 示例 2：
//
// 输入：time = "0?:0?"
//输出：100
//解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
//
//
// 示例 3：
//
// 输入：time = "??:??"
//输出：1440
//解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
//
//
//
//
// 提示：
//
//
// time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
// "00" <= hh <= "23"
// "00" <= mm <= "59"
// 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。
//
//
// Related Topics 字符串 枚举 👍 39 👎 0

package leetcode.editor.cn;
public class NumberOfValidClockTimes{
    public static void main(String[] args){
        Solution solution = new NumberOfValidClockTimes().new Solution();
        System.out.println(solution.countTime("?5:00"));
        System.out.println(solution.countTime("0?:0?"));
        System.out.println(solution.countTime("??:??"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTime(String time) {
        int ans = 1;
        char[] chars = time.toCharArray();
        if (chars[0] == '?' && chars[1] == '?') {
            ans *= 24;
        }else{
            if (chars[0] == '?') {
                if (chars[1] <= '3' || chars[1] == '?') {
                    ans *= 3;
                } else {
                    ans *= 2;
                }
            } else if (chars[1] == '?') {
                if (chars[0] == '2') {
                    ans *= 4;
                } else {
                    ans *= 10;
                }
            }
        }
        if(chars[3] == '?' && chars[4] == '?') {
            ans *= 60;
        } else if (chars[3] == '?') {
            ans *= 6;
        } else if (chars[4] == '?') {
            ans *= 10;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}