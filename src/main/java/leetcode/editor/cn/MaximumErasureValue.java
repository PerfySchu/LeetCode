//2025-07-22 17:25:33
//第1695题
//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
//
// 返回 只删除一个 子数组可获得的 最大得分 。
//
// 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,2,4,5,6]
//输出：17
//解释：最优子数组是 [2,4,5,6]
//
//
// 示例 2：
//
//
//输入：nums = [5,2,1,2,5,2,1,2,5]
//输出：8
//解释：最优子数组是 [5,2,1] 或 [1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁴
//
//
// Related Topics 数组 哈希表 滑动窗口 👍 131 👎 0

package leetcode.editor.cn;
public class MaximumErasureValue{
    public static void main(String[] args){
        Solution solution = new MaximumErasureValue().new Solution();
        System.out.println(solution.maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(solution.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int [] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int max = 0;
        int[] last = new int[10001];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, last[nums[i]]);
            max = Math.max(max, sum[i + 1] - sum[start]);
            last[nums[i]] = i + 1;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}