//2024-12-16 14:25:49
//第3264题
//给你一个整数数组 nums ，一个整数 k 和一个整数 multiplier 。
//
// 你需要对 nums 执行 k 次操作，每次操作中：
//
//
// 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
// 将 x 替换为 x * multiplier 。
//
//
// 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
//
//
// 输出：[8,4,6,5,6]
//
// 解释：
//
//
//
//
// 操作
// 结果
//
//
// 1 次操作后
// [2, 2, 3, 5, 6]
//
//
// 2 次操作后
// [4, 2, 3, 5, 6]
//
//
// 3 次操作后
// [4, 4, 3, 5, 6]
//
//
// 4 次操作后
// [4, 4, 6, 5, 6]
//
//
// 5 次操作后
// [8, 4, 6, 5, 6]
//
//
//
//
// 示例 2：
//
//
// 输入：nums = [1,2], k = 3, multiplier = 4
//
//
// 输出：[16,8]
//
// 解释：
//
//
//
//
// 操作
// 结果
//
//
// 1 次操作后
// [4, 2]
//
//
// 2 次操作后
// [4, 8]
//
//
// 3 次操作后
// [16, 8]
//
//
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
// 1 <= k <= 10
// 1 <= multiplier <= 5
//
//
// Related Topics 数组 数学 模拟 堆（优先队列） 👍 24 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalArrayStateAfterKMultiplicationOperationsI{
    public static void main(String[] args){
        Solution solution = new FinalArrayStateAfterKMultiplicationOperationsI().new Solution();
        System.out.println(Arrays.toString(solution.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        System.out.println(Arrays.toString(solution.getFinalState(new int[]{1, 2}, 3, 4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int m = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[m]) {
                    m = j;
                }
            }
            nums[m] *= multiplier;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}