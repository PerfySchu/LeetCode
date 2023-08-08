//2023-08-08 09:50:18
//第1749题
//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
//
// abs(x) 定义如下：
//
//
// 如果 x 是负整数，那么 abs(x) = -x 。
// 如果 x 是非负整数，那么 abs(x) = x 。
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
//
//
// 示例 2：
//
//
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics 数组 动态规划 👍 53 👎 0

package leetcode.editor.cn;
public class MaximumAbsoluteSumOfAnySubarray{
    public static void main(String[] args){
        Solution solution = new MaximumAbsoluteSumOfAnySubarray().new Solution();
        System.out.println(solution.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println(solution.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
        System.out.println(solution.maxAbsoluteSum(new int[]{-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int pre = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            max = Math.max(max, pre);
            min = Math.min(min, pre);
        }
        return max - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}