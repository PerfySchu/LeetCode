//2023-10-26 10:22:35
//第2520题
//给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
//
// 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
//
//
//
// 示例 1：
//
// 输入：num = 7
//输出：1
//解释：7 被自己整除，因此答案是 1 。
//
//
// 示例 2：
//
// 输入：num = 121
//输出：2
//解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
//
//
// 示例 3：
//
// 输入：num = 1248
//输出：4
//解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
//
//
//
//
// 提示：
//
//
// 1 <= num <= 10⁹
// num 的数位中不含 0
//
//
// Related Topics 数学 👍 21 👎 0

package leetcode.editor.cn;
public class CountTheDigitsThatDivideANumber{
    public static void main(String[] args){
        Solution solution = new CountTheDigitsThatDivideANumber().new Solution();
        System.out.println(solution.countDigits(1248));
        System.out.println(solution.countDigits(121));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigits(int num) {
        int temp = num;
        int ans = 0;
        while (temp > 10){
            ans += num % (temp % 10) == 0 ? 1 : 0;
            temp = temp / 10;
        }
        ans += num % temp == 0 ? 1 : 0;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}