//2024-07-03 13:54:04
//第3099题
//如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x
//各个数位上的数字之和，否则，返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入： x = 18
//
//
// 输出： 9
//
// 解释：
//
// x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
//
// 示例 2：
//
//
// 输入： x = 23
//
//
// 输出： -1
//
// 解释：
//
// x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
//
//
//
// 提示：
//
//
// 1 <= x <= 100
//
//
// Related Topics 数学 👍 15 👎 0

package leetcode.editor.cn;
public class HarshadNumber{
    public static void main(String[] args){
        Solution solution = new HarshadNumber().new Solution();
        System.out.println(solution.sumOfTheDigitsOfHarshadNumber(18));
        System.out.println(solution.sumOfTheDigitsOfHarshadNumber(23));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int ans = 0;
        int num = x;
        while(x/10 > 0){
            ans += x%10;
            x = x/10;
        }
        ans += x;
        return num%ans == 0 ? ans : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}