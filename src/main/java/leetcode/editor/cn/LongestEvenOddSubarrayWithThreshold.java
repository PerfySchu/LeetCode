//2023-11-16 15:47:35
//第2760题
//给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
//
// 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
//
//
//
// nums[l] % 2 == 0
// 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
// 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
//
//
// 以整数形式返回满足题目要求的最长子数组的长度。
//
// 注意：子数组 是数组中的一个连续非空元素序列。
//
//
//
// 示例 1：
//
// 输入：nums = [3,2,5,4], threshold = 5
//输出：3
//解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
//
// 示例 2：
//
// 输入：nums = [1,2], threshold = 2
//输出：1
//解释：
//在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
//该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
//
//
// 示例 3：
//
// 输入：nums = [2,3,4,5], threshold = 4
//输出：3
//解释：
//在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。
//该子数组满足上述全部条件。
//因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
// 1 <= threshold <= 100
//
//
// Related Topics 数组 滑动窗口 👍 64 👎 0

package leetcode.editor.cn;
public class LongestEvenOddSubarrayWithThreshold{
    public static void main(String[] args){
        Solution solution = new LongestEvenOddSubarrayWithThreshold().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0, length = 0;
        for(int num : nums) {
            int l = length % 2;
            int k = num % 2;
            // 当前数字大于阈值, 或者是不符预期的奇数, 则重置长度为 0
            if(num > threshold || (l == 0 && k == 1)) {
                length = 0;
                // 若是不符预期的偶数, 可以重新作为符合要求数组的开头, 则重置长度为 1
            } else if(l == 1 && k == 0) {
                length = 1;
                // 否则就是符合预期, 则长度增加并对比答案大小
            } else {
                max = Math.max(max, ++length);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}