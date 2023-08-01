//2023-08-01 09:45:37
//第2681题
//给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
//
//
// i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])²
//* min(nums[i0],nums[i1] ... nums[ik]) 。
//
//
// 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,1,4]
//输出：141
//解释：
//第 1 组：[2] 的力量为 2² * 2 = 8 。
//第 2 组：[1] 的力量为 1² * 1 = 1 。
//第 3 组：[4] 的力量为 4² * 4 = 64 。
//第 4 组：[2,1] 的力量为 2² * 1 = 4 。
//第 5 组：[2,4] 的力量为 4² * 2 = 32 。
//第 6 组：[1,4] 的力量为 4² * 1 = 16 。
//第​ ​​​​​​7 组：[2,1,4] 的力量为 4²​​​​​​​ * 1 = 16 。
//所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1]
//输出：7
//解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics 数组 数学 前缀和 排序 👍 42 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PowerOfHeroes{
    public static void main(String[] args){
        Solution solution = new PowerOfHeroes().new Solution();
        System.out.println(solution.sumOfPower(new int[]{2,1,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] preSum = new int[nums.length+1];
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (nums[i] + preSum[i]) % mod;
            preSum[i+1] = (preSum[i] + dp[i]) % mod;
            res = (int)((res + (long)nums[i] * nums[i] % mod * dp[i]) % mod);
            if (res < 0){
                res += mod;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}