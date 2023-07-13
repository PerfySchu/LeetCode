//2023-07-12 09:00:30
//第2544题
//给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
//
//
// 最高有效位 上的数字分配到 正 号。
// 剩余每位上数字的符号都与其相邻数字相反。
//
//
// 返回所有数字及其对应符号的和。
//
//
//
// 示例 1：
//
//
//输入：n = 521
//输出：4
//解释：(+5) + (-2) + (+1) = 4
//
// 示例 2：
//
//
//输入：n = 111
//输出：1
//解释：(+1) + (-1) + (+1) = 1
//
//
// 示例 3：
//
//
//输入：n = 886996
//输出：0
//解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
//
//
//
//
// Related Topics 数学 👍 21 👎 0

package leetcode.editor.cn;
public class AlternatingDigitSum{
    public static void main(String[] args){
        Solution solution = new AlternatingDigitSum().new Solution();
        System.out.println(solution.alternateDigitSum(521));
        System.out.println(solution.alternateDigitSum(111));
        System.out.println(solution.alternateDigitSum(10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        boolean positive = true;
        char[] chars = String.valueOf(n).toCharArray();
        for (char aChar : chars) {
            if(positive){
                sum += aChar - '0';
            }else{
                sum -= aChar - '0';
            }
            positive = !positive;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}