//2024-06-14 09:11:42
//第2786题
//给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
//
// 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
//
//
// 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
// 对于你访问的位置 i ，你可以获得分数 nums[i] 。
// 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
//
//
// 请你返回你能得到的 最大 得分之和。
//
// 注意 ，你一开始的分数为 nums[0] 。
//
//
//
// 示例 1：
//
// 输入：nums = [2,3,6,1,9,2], x = 5
//输出：13
//解释：我们可以按顺序访问数组中的位置：0 -> 2 -> 3 -> 4 。
//对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -> 3 让你失去 x = 5 分。
//总得分为：2 + 6 + 1 + 9 - 5 = 13 。
//
//
// 示例 2：
//
// 输入：nums = [2,4,6,8], x = 3
//输出：20
//解释：数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
//总得分为：2 + 4 + 6 + 8 = 20 。
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// 1 <= nums[i], x <= 10⁶
//
//
// Related Topics 数组 动态规划 👍 21 👎 0

package leetcode.editor.cn;
public class VisitArrayPositionsToMaximizeScore{
    public static void main(String[] args){
        Solution solution = new VisitArrayPositionsToMaximizeScore().new Solution();
        System.out.println(solution.maxScore(new int[]{2,3,6,1,9,2}, 5));
        System.out.println(solution.maxScore(new int[]{2,4,6,8}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxScore(int[] nums, int x) {
        long ans = nums[0];
        long[] dp  = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = nums[i] % 2;
            long cur = Math.max(dp[parity] + nums[i], dp[1 - parity] - x + nums[i]);
            ans = Math.max(ans, cur);
            dp[parity] = Math.max(dp[parity], cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}