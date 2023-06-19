//2023-06-19 09:26:42
//第1262题
//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
//
// 示例 2：
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
//
//
// 示例 3：
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 4 * 10^4
// 1 <= nums[i] <= 10^4
//
//
// Related Topics 贪心 数组 动态规划 排序 👍 235 👎 0

package leetcode.editor.cn;
public class GreatestSumDivisibleByThree{
    public static void main(String[] args){
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(solution.maxSumDivThree(new int[]{4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i + 1][j] = Math.max(f[i][j], f[i][(j + nums[i]) % 3] + nums[i]);
            }
        }
        return f[n][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}