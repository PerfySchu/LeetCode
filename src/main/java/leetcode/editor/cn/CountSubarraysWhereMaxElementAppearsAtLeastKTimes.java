//2025-04-29 08:44:36
//第2962题
//给你一个整数数组 nums 和一个 正整数 k 。
//
// 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
//
// 子数组是数组中的一个连续元素序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,2,3,3], k = 2
//输出：6
//解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3]
//。
//
//
// 示例 2：
//
//
//输入：nums = [1,4,2,1], k = 3
//输出：0
//解释：没有子数组包含元素 4 至少 3 次。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁶
// 1 <= k <= 10⁵
//
//
// Related Topics 数组 滑动窗口 👍 65 👎 0

package leetcode.editor.cn;
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes{
    public static void main(String[] args){
        Solution solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes().new Solution();
        System.out.println(solution.countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(solution.countSubarrays(new int[]{1,4,2,1}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            arr[nums[right]]++;
            while (arr[max] >= k) {
                count += nums.length - right;
                arr[nums[left]]--;
                left++;
            }
            right++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}