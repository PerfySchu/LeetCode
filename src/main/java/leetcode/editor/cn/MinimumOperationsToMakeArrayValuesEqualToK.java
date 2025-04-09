//2025-04-09 10:44:57
//第3375题
//给你一个整数数组 nums 和一个整数 k 。
//
// 如果一个数组中所有 严格大于 h 的整数值都 相等 ，那么我们称整数 h 是 合法的 。
//
// 比方说，如果 nums = [10, 8, 10, 8] ，那么 h = 9 是一个 合法 整数，因为所有满足 nums[i] > 9 的数都等于 10
//，但是 5 不是 合法 整数。
//
// 你可以对 nums 执行以下操作：
//
//
// 选择一个整数 h ，它对于 当前 nums 中的值是合法的。
// 对于每个下标 i ，如果它满足 nums[i] > h ，那么将 nums[i] 变为 h 。
//
//
// 你的目标是将 nums 中的所有元素都变为 k ，请你返回 最少 操作次数。如果无法将所有元素都变 k ，那么返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [5,2,5,4,5], k = 2
//
//
// 输出：2
//
// 解释：
//
// 依次选择合法整数 4 和 2 ，将数组全部变为 2 。
//
// 示例 2：
//
//
// 输入：nums = [2,1,2], k = 2
//
//
// 输出：-1
//
// 解释：
//
// 没法将所有值变为 2 。
//
// 示例 3：
//
//
// 输入：nums = [9,7,5,3], k = 1
//
//
// 输出：4
//
// 解释：
//
// 依次选择合法整数 7 ，5 ，3 和 1 ，将数组全部变为 1 。
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
// Related Topics 数组 哈希表 👍 14 👎 0

package leetcode.editor.cn;

import java.util.Set;
import java.util.HashSet;

public class MinimumOperationsToMakeArrayValuesEqualToK{
    public static void main(String[] args){
        Solution solution = new MinimumOperationsToMakeArrayValuesEqualToK().new Solution();
        System.out.println(solution.minOperations(new int[]{5,2,5,4,5},2));
        System.out.println(solution.minOperations(new int[]{2,1,2},2));
        System.out.println(solution.minOperations(new int[]{9,7,5,3},1) );
        System.out.println(solution.minOperations(new int[]{9,7,5,3},3) );
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int min = 101;
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
        }
        if (min < k) {
            return -1;
        }
        return set.size() - (min == k ? 1 : 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}