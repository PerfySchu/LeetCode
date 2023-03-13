//2023-03-10 15:24:50
//第213题
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 3：
//
//
//输入：nums = [1,2,3]
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
//
// Related Topics 数组 动态规划 👍 1292 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class HouseRobberIi{
    public static void main(String[] args){
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{2,3,2}));
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(
                //不偷最后一家
                cal(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                //不偷第一家
                cal(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int cal(int[] nums){
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        sum[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            sum[i] = Math.max(sum[i-1], sum[i-2]+nums[i-1]);
        }
        return sum[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}