//2025-01-17 10:05:44
//第3097题
//给你一个 非负 整数数组 nums 和一个整数 k 。
//
// 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
//
// 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3], k = 2
//
//
// 输出：1
//
// 解释：
//
// 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
//
// 示例 2：
//
//
// 输入：nums = [2,1,8], k = 10
//
//
// 输出：3
//
// 解释：
//
// 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
//
// 示例 3：
//
//
// 输入：nums = [1,2], k = 0
//
//
// 输出：1
//
// 解释：
//
// 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁵
// 0 <= nums[i] <= 109
// 0 <= k <= 10⁹
//
//
// Related Topics 位运算 数组 滑动窗口 👍 32 👎 0

package leetcode.editor.cn;
public class ShortestSubarrayWithOrAtLeastKIi{
    public static void main(String[] args){
        Solution solution = new ShortestSubarrayWithOrAtLeastKIi().new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1,2,3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2,1,8}, 10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length;
            int[] bits = new int[30];
            int res = Integer.MAX_VALUE;
            for (int left = 0, right = 0; right < n; right++) {
                for (int i = 0; i < 30; i++) {
                    bits[i] += (nums[right] >> i) & 1;
                }
                while (left <= right && calc(bits) >= k) {
                    res = Math.min(res, right - left + 1);
                    for (int i = 0; i < 30; i++) {
                        bits[i] -= (nums[left] >> i) & 1;
                    }
                    left++;
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int calc(int[] bits) {
            int ans = 0;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] > 0) {
                    ans |= 1 << i;
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}