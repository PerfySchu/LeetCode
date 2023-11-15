//2023-11-15 09:51:26
//第2656题
//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
//
//
// 从 nums 中选择一个元素 m 。
// 将选中的元素 m 从数组中删除。
// 将新元素 m + 1 添加到数组中。
// 你的得分增加 m 。
//
//
// 请你返回执行以上操作恰好 k 次后的最大得分。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4,5], k = 3
//输出：18
//解释：我们需要从 nums 中恰好选择 3 个元素并最大化得分。
//第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
//第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
//第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
//所以我们返回 18 。
//18 是可以得到的最大答案。
//
//
// 示例 2：
//
//
//输入：nums = [5,5,5], k = 2
//输出：11
//解释：我们需要从 nums 中恰好选择 2 个元素并最大化得分。
//第一次选择 5 。和为 5 ，nums = [5,5,6] 。
//第二次选择 6 。和为 6 ，nums = [5,5,7] 。
//所以我们返回 11 。
//11 是可以得到的最大答案。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
// 1 <= k <= 100
//
//
// Related Topics 贪心 数组 👍 28 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSumWithExactlyKElements{
    public static void main(String[] args){
        Solution solution = new MaximumSumWithExactlyKElements().new Solution();
        System.out.println(solution.maximizeSum(new int[]{1,2,3,4,5}, 3));
        System.out.println(solution.maximizeSum(new int[]{5,5}, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int num = nums[nums.length - 1];
        return k * (num + num + k-1) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}