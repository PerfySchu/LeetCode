//2024-10-25 15:17:08
//第3180题
//给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
//
// 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
//
//
// 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
// 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x +
//rewardValues[i]），并 标记 下标 i。
//
//
// 以整数形式返回执行最优操作能够获得的 最大 总奖励。
//
//
//
// 示例 1：
//
//
// 输入：rewardValues = [1,1,3,3]
//
//
// 输出：4
//
// 解释：
//
// 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
//
// 示例 2：
//
//
// 输入：rewardValues = [1,6,4,3,2]
//
//
// 输出：11
//
// 解释：
//
// 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
//
//
//
// 提示：
//
//
// 1 <= rewardValues.length <= 2000
// 1 <= rewardValues[i] <= 2000
//
//
// Related Topics 数组 动态规划 👍 45 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumTotalRewardUsingOperationsI{
    public static void main(String[] args){
        Solution solution = new MaximumTotalRewardUsingOperationsI().new Solution();
        System.out.println(solution.maxTotalReward(new int[]{1,1,3,3}));
        System.out.println(solution.maxTotalReward(new int[]{1,6,4,3,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int max = rewardValues[rewardValues.length-1];
        int[] dp = new int[2*max];
        dp[0] = 1;
        for (int x : rewardValues) {
            for(int k = 2*x-1; k >= x; k--){
                if(dp[k-x] == 1){
                    dp[k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1){
                res = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}