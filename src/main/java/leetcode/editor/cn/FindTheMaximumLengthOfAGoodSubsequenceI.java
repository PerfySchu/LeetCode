//2024-09-06 08:47:45
//第3176题
//给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过
//k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
//
// 请你返回 nums 中 好 子序列 的最长长度
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,1,1,3], k = 2
//
//
// 输出：4
//
// 解释：
//
// 最长好子序列为 [1,2,1,1,3] 。
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,4,5,1], k = 0
//
//
// 输出：2
//
// 解释：
//
// 最长好子序列为 [1,2,3,4,5,1] 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 500
// 1 <= nums[i] <= 10⁹
// 0 <= k <= min(nums.length, 25)
//
//
// Related Topics 数组 哈希表 动态规划 👍 12 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindTheMaximumLengthOfAGoodSubsequenceI{
    public static void main(String[] args){
        Solution solution = new FindTheMaximumLengthOfAGoodSubsequenceI().new Solution();
        System.out.println(solution.maximumLength(new int[]{1,2,1,1,3}, 2));
        System.out.println(solution.maximumLength(new int[]{1,2,3,4,5,1}, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 1;
        int n = nums.length;
        final int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                for (int m = 0; m <= k; m++) {
                    if (nums[i] == nums[j]) {
                        dp[i][m] = Math.max(dp[i][m], dp[j][m]+1);
                    }else if(m>0){
                        dp[i][m] = Math.max(dp[i][m], dp[j][m-1]+1);
                    }
                    ans = Math.max(ans, dp[i][m]);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}